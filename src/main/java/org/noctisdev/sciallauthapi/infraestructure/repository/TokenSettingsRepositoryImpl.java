package org.noctisdev.sciallauthapi.infraestructure.repository;

import jakarta.persistence.EntityNotFoundException;
import org.noctisdev.sciallauthapi.domain.models.TokenSetting;
import org.noctisdev.sciallauthapi.domain.models.enums.TokenType;
import org.noctisdev.sciallauthapi.domain.repository.ITokenSettingsRepository;
import org.noctisdev.sciallauthapi.infraestructure.entities.enums.TokenTypeEntity;
import org.noctisdev.sciallauthapi.infraestructure.mapper.ITokenSettingsMapper;
import org.noctisdev.sciallauthapi.infraestructure.repository.jpa.TokenSettingEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenSettingsRepositoryImpl implements ITokenSettingsRepository {

    @Autowired
    private ITokenSettingsMapper mapper;

    @Autowired
    private TokenSettingEntityRepository jpaRepository;

    @Override
    public TokenSetting findActive(TokenType type) {
        return jpaRepository.findByTokenTypeEntityAndIsActive(TokenTypeEntity.valueOf(type.name()), true)
                .map(mapper::toDomain).orElseThrow(EntityNotFoundException::new);
    }
}
