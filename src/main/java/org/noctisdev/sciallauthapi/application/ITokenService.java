package org.noctisdev.sciallauthapi.application;

import org.noctisdev.sciallauthapi.domain.models.Token;

public interface ITokenService {
    Token createToken();
    Token find(String token);
}
