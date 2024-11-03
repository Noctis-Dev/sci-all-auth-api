package org.noctisdev.sciallauthapi.application.impl;

import org.noctisdev.sciallauthapi.application.ITokenSettingsService;
import org.noctisdev.sciallauthapi.domain.models.TokenSetting;
import org.noctisdev.sciallauthapi.domain.models.enums.TokenType;
import org.noctisdev.sciallauthapi.domain.repository.ITokenSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenSettingsServiceImpl implements ITokenSettingsService {

    @Autowired
    private ITokenSettingsRepository repository;

    @Override
    public TokenSetting find(TokenType type) {
        return repository.findActive(type);
    }
}
