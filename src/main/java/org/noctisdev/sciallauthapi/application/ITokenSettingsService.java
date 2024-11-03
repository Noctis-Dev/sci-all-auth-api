package org.noctisdev.sciallauthapi.application;


import org.noctisdev.sciallauthapi.domain.models.TokenSetting;
import org.noctisdev.sciallauthapi.domain.models.enums.TokenType;

public interface ITokenSettingsService {
    TokenSetting find(TokenType type);
}
