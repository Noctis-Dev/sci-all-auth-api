package org.noctisdev.sciallauthapi.application;

import org.noctisdev.sciallauthapi.domain.models.Contact;
import org.noctisdev.sciallauthapi.infraestructure.dto.BaseResponse;
import org.noctisdev.sciallauthapi.infraestructure.dto.request.ContactRequest;

import java.util.UUID;

public interface IContactService {
    BaseResponse createContact(ContactRequest contact);
    Contact find(UUID uuid);
}
