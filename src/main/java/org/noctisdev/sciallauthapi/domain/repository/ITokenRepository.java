package org.noctisdev.sciallauthapi.domain.repository;

import jakarta.validation.Valid;
import org.noctisdev.sciallauthapi.domain.models.Token;

public interface ITokenRepository {
    Token save(@Valid Token token);
    Token find(String token);
}
