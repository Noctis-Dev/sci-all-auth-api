package org.noctisdev.sciallauthapi.infraestructure.repository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.noctisdev.sciallauthapi.domain.models.Token;
import org.noctisdev.sciallauthapi.domain.repository.ITokenRepository;
import org.noctisdev.sciallauthapi.infraestructure.mapper.ITokenMapper;
import org.noctisdev.sciallauthapi.infraestructure.repository.jpa.TokenEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenRepositoryImpl implements ITokenRepository {

    @Autowired
    private ITokenMapper mapper;

    @Autowired
    private TokenEntityRepository jpaRepository;

    @Override
    public Token save(@Valid Token token) {
        return mapper.toDomain(jpaRepository.save(mapper.toEntity(token)));
    }

    @Override
    public Token find(String token) {
        return jpaRepository.findByToken(token).map(mapper::toDomain).orElseThrow(EntityNotFoundException::new);
    }
}
