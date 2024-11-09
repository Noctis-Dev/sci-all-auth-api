package org.noctisdev.sciallauthapi.application.impl;

import org.noctisdev.sciallauthapi.application.*;
import org.noctisdev.sciallauthapi.domain.broker.IMessageProducer;
import org.noctisdev.sciallauthapi.domain.models.Contact;
import org.noctisdev.sciallauthapi.domain.models.Credential;
import org.noctisdev.sciallauthapi.domain.models.Token;
import org.noctisdev.sciallauthapi.domain.models.User;
import org.noctisdev.sciallauthapi.domain.models.enums.UserStatus;
import org.noctisdev.sciallauthapi.application.dto.BaseResponse;
import org.noctisdev.sciallauthapi.application.dto.request.CredentialRequest;
import org.noctisdev.sciallauthapi.application.dto.response.SignUpResponse;
import org.noctisdev.sciallauthapi.application.dto.response.UserResponse;
import org.noctisdev.sciallauthapi.application.factory.EventFactory;
import org.noctisdev.sciallauthapi.utils.ThreadsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private ICredentialService credentialService;

    @Autowired
    private ITokenService tokenService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IContactService contactService;

    @Autowired
    private IMessageProducer messageProducer;

    @Override
    public BaseResponse signUp(CredentialRequest request) {
        Contact contact = contactService.find(request.contactUuid());
        Token savedToken = tokenService.createToken();

        ThreadsUtil.runTask(() -> {
            EventFactory factory = EventFactory.builder()
                    .type(request.type())
                    .subject("Verification code SCI-ALL")
                    .message("you SCI-ALL Verification Code: " + savedToken.getToken())
                    .email(contact.getEmail())
                    .phoneNumber(contact.getPhoneNumber())
                    .producer(messageProducer).build();

            factory.getNotification().send();
        });

        Credential savedCredential = credentialService.create(request, savedToken, contact);
        User savedUser = userService.create(contact);

        SignUpResponse response = new SignUpResponse();
        response.setUserUuid(savedUser.getUserUuid());
        response.setContactUuid(contact.getContactUuid());
        response.setCredentialUuid(savedCredential.getCredentialUuid());

        return BaseResponse.builder()
                .data(response)
                .message("The user account was created successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .status(200).build();
    }

    @Override
    public BaseResponse verifyToken(String token, UUID credentialUuid) {
        Credential credential = credentialService.find(credentialUuid);
        User user = credential.getContact().getUser();

        if (!credential.getToken().getToken().equals(token)) {
            throw new RuntimeException();
        }

        user.setActivatedAt(LocalDate.now());
        user.setStatus(UserStatus.ACTIVE);
        credential.setVerifiedAt(LocalDate.now());

        return BaseResponse.builder()
                .data(toUserResponse(user))
                .message("Credential verified successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .status(200).build();
    }

    private UserResponse toUserResponse(User user) {
        return new UserResponse(
            user.getUserUuid(),
            user.getCreatedAt(),
            user.getActivatedAt(),
            user.getDeletedAt(),
            user.getStatus()
        );
    }

}
