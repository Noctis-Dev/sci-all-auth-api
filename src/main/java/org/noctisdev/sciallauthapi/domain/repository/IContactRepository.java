package org.noctisdev.sciallauthapi.domain.repository;

import jakarta.validation.Valid;
import org.noctisdev.sciallauthapi.domain.models.Contact;

import java.util.UUID;

public interface IContactRepository {
    Contact create(@Valid Contact contact);
    Contact find(UUID uuid);
}
