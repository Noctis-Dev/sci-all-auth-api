package org.noctisdev.sciallauthapi.infraestructure.mapper.impl;

import org.noctisdev.sciallauthapi.domain.models.TokenSetting;
import org.noctisdev.sciallauthapi.domain.models.enums.TokenType;
import org.noctisdev.sciallauthapi.infraestructure.entities.TokenSettingEntity;
import org.noctisdev.sciallauthapi.infraestructure.entities.enums.TokenTypeEntity;
import org.noctisdev.sciallauthapi.infraestructure.mapper.ITokenSettingsMapper;
import org.springframework.stereotype.Component;

@Component
public class TokenSettingsMapperImpl implements ITokenSettingsMapper {

    @Override
    public TokenSetting toDomain(TokenSettingEntity entity) {
        TokenSetting tokenSetting = new TokenSetting();

        tokenSetting.setId(entity.getId());
        tokenSetting.setIsActive(entity.getIsActive());
        tokenSetting.setTokenExpiration(entity.getTokenExpiration());
        tokenSetting.setRefreshTokenExpiration(entity.getRefreshTokenExpiration());
        tokenSetting.setTokenType(TokenType.valueOf(entity.getTokenTypeEntity().name()));

        return tokenSetting;
    }

    @Override
    public TokenSettingEntity toEntity(TokenSetting model) {
        TokenSettingEntity tokenSettingEntity = new TokenSettingEntity();

        tokenSettingEntity.setId(model.getId());
        tokenSettingEntity.setIsActive(model.getIsActive());
        tokenSettingEntity.setTokenExpiration(model.getTokenExpiration());
        tokenSettingEntity.setRefreshTokenExpiration(model.getRefreshTokenExpiration());
        tokenSettingEntity.setTokenTypeEntity(TokenTypeEntity.valueOf(model.getTokenType().name()));

        return tokenSettingEntity;
    }

}
