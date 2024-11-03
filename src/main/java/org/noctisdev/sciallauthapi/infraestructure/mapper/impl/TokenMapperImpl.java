package org.noctisdev.sciallauthapi.infraestructure.mapper.impl;

import org.noctisdev.sciallauthapi.domain.models.Token;
import org.noctisdev.sciallauthapi.domain.models.enums.TokenType;
import org.noctisdev.sciallauthapi.infraestructure.entities.TokenEntity;
import org.noctisdev.sciallauthapi.infraestructure.entities.enums.TokenTypeEntity;
import org.noctisdev.sciallauthapi.infraestructure.mapper.ITokenMapper;
import org.noctisdev.sciallauthapi.infraestructure.mapper.ITokenSettingsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenMapperImpl implements ITokenMapper {

    @Autowired
    private ITokenSettingsMapper tokenSettingsMapper;

    @Override
    public Token toDomain(TokenEntity entity) {
        Token token = new Token();

        token.setId(entity.getId());
        token.setToken(entity.getToken());
        token.setExpirationDate(entity.getExpirationDate());
        token.setTokenType(TokenType.valueOf(entity.getTokenTypeEntity().name()));
        token.setTokenSetting(tokenSettingsMapper.toDomain(entity.getTokenSettingEntity()));

        return token;
    }

    @Override
    public TokenEntity toEntity(Token model) {
        TokenEntity tokenEntity = new TokenEntity();

        tokenEntity.setId(model.getId());
        tokenEntity.setToken(model.getToken());
        tokenEntity.setExpirationDate(model.getExpirationDate());
        tokenEntity.setTokenTypeEntity(TokenTypeEntity.valueOf(model.getTokenType().name()));
        tokenEntity.setTokenSettingEntity(tokenSettingsMapper.toEntity(model.getTokenSetting()));

        return tokenEntity;
    }
}
