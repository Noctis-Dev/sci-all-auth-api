package org.noctisdev.sciallauthapi.domain.repository;

import jakarta.validation.Valid;
import org.noctisdev.sciallauthapi.domain.models.User;

import java.util.UUID;

public interface IUserRepository {

    User save(@Valid User userEntity);
    User find(UUID userUuid);

}
