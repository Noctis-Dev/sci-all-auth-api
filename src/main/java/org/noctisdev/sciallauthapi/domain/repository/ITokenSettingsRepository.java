package org.noctisdev.sciallauthapi.domain.repository;


import org.noctisdev.sciallauthapi.domain.models.TokenSetting;
import org.noctisdev.sciallauthapi.domain.models.enums.TokenType;

public interface ITokenSettingsRepository {
    TokenSetting findActive(TokenType type);
}
