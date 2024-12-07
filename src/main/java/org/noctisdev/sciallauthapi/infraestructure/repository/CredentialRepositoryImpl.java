package org.noctisdev.sciallauthapi.infraestructure.repository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.noctisdev.sciallauthapi.domain.models.Credential;
import org.noctisdev.sciallauthapi.domain.repository.ICredentialRepository;
import org.noctisdev.sciallauthapi.infraestructure.mapper.ICredentialMapper;
import org.noctisdev.sciallauthapi.infraestructure.repository.jpa.CredentialEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CredentialRepositoryImpl implements ICredentialRepository {

    @Autowired
    private ICredentialMapper mapper;

    @Autowired
    private CredentialEntityRepository jpaRepository;

    @Override
    public Credential save(@Valid Credential credentialEntity) {
        return mapper.toDomain(jpaRepository.save(mapper.toEntity(credentialEntity)));
    }

    @Override
    public Credential find(UUID credentialUuid) {
        return jpaRepository.findByCredentialUuid(credentialUuid)
                .map(mapper::toDomain).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Credential find(String phoneNumber) {
        return jpaRepository.find(phoneNumber)
                .map(mapper::toDomain).orElseThrow(EntityNotFoundException::new);
    }
}
