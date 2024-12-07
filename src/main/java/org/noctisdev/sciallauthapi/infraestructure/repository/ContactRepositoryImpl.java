package org.noctisdev.sciallauthapi.infraestructure.repository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.noctisdev.sciallauthapi.domain.models.Contact;
import org.noctisdev.sciallauthapi.domain.repository.IContactRepository;
import org.noctisdev.sciallauthapi.infraestructure.mapper.IContactMapper;
import org.noctisdev.sciallauthapi.infraestructure.repository.jpa.ContactEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ContactRepositoryImpl implements IContactRepository {

    @Autowired
    @Qualifier("contactMapperImpl")
    private IContactMapper mapper;

    @Autowired
    private ContactEntityRepository jpaRepository;

    @Override
    public Contact create(@Valid Contact contact) {
        return mapper.toDomain(jpaRepository.save(mapper.toEntity(contact)));
    }

    @Override
    public Contact find(UUID uuid) {
        return jpaRepository.findByContactUuid(uuid).map(mapper::toDomain).orElseThrow(EntityNotFoundException::new);
    }
}
