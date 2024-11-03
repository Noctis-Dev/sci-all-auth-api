package org.noctisdev.sciallauthapi.domain.repository;

import jakarta.validation.Valid;
import org.noctisdev.sciallauthapi.domain.models.Credential;

import java.util.UUID;

public interface ICredentialRepository {

    Credential create(@Valid Credential credentialEntity);
    Credential find(UUID credentialUuid);
    Credential find(String phoneNumber);

}
