package org.noctisdev.sciallauthapi.application.impl;

import org.noctisdev.sciallauthapi.application.ICredentialService;
import org.noctisdev.sciallauthapi.domain.models.Contact;
import org.noctisdev.sciallauthapi.domain.models.Credential;
import org.noctisdev.sciallauthapi.domain.models.Token;
import org.noctisdev.sciallauthapi.domain.repository.ICredentialRepository;
import org.noctisdev.sciallauthapi.infraestructure.dto.request.CredentialRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class CredentialServiceImpl implements ICredentialService {

    @Autowired
    private ICredentialRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Credential create(CredentialRequest request, Token token, Contact contact) {
        Credential credential = toCredential(request);
        credential.setContact(contact);
        credential.setToken(token);
        credential.setPassword(encoder.encode(credential.getPassword()));
        return repository.create(credential);
    }

    @Override
    public Credential find(UUID credentialUuid) {
        return repository.find(credentialUuid);
    }

    @Override
    public Credential find(String phoneNumber) {
        return repository.find(phoneNumber);
    }

    private Credential toCredential(CredentialRequest request) {
        Credential credential = new Credential();

        credential.setCredentialUuid(UUID.randomUUID());
        credential.setPassword(request.password());
        credential.setCreatedAt(LocalDate.now());

        return credential;
    }
}
