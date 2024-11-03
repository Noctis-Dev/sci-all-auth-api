package org.noctisdev.sciallauthapi.application.impl;

import org.noctisdev.sciallauthapi.application.IContactService;
import org.noctisdev.sciallauthapi.domain.broker.IMessageProducer;
import org.noctisdev.sciallauthapi.domain.events.NotificationEmailEvent;
import org.noctisdev.sciallauthapi.domain.models.Contact;
import org.noctisdev.sciallauthapi.domain.repository.IContactRepository;
import org.noctisdev.sciallauthapi.infraestructure.dto.BaseResponse;
import org.noctisdev.sciallauthapi.infraestructure.dto.request.ContactRequest;
import org.noctisdev.sciallauthapi.infraestructure.dto.response.ContactResponse;
import org.noctisdev.sciallauthapi.utils.ThreadsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class ContactServiceImpl implements IContactService {

    @Autowired
    private IContactRepository repository;

    @Autowired
    private IMessageProducer messageProducer;

    @Override
    public BaseResponse createContact(ContactRequest contact) {
        Contact savedContact = repository.create(toContact(contact));

        ThreadsUtil.runTask(() -> {
            NotificationEmailEvent event = new NotificationEmailEvent();
            event.setTo(savedContact.getEmail());
            event.setSubject("Welcome to SCI-ALL");
            event.setBody("Your account was created successfully");
            messageProducer.sendEmailNotification(event);
        });

        return BaseResponse.builder()
                .data(toContactResponse(savedContact))
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .status(200).build();
    }

    @Override
    public Contact find(UUID uuid) {
        return repository.find(uuid);
    }

    private Contact toContact(ContactRequest request) {
        Contact contact = new Contact();

        contact.setContactUuid(UUID.randomUUID());
        contact.setPhoneNumber(request.phoneNumber());
        contact.setEmail(request.email());
        contact.setCreatedAt(LocalDate.now());

        return contact;
    }

    private ContactResponse toContactResponse(Contact contact) {
        return new ContactResponse(
                contact.getContactUuid(),
                contact.getPhoneNumber(),
                contact.getEmail(),
                contact.getCreatedAt()
        );
    }
}
