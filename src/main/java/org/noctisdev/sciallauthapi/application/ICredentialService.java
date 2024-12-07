package org.noctisdev.sciallauthapi.application;

import org.noctisdev.sciallauthapi.domain.models.Contact;
import org.noctisdev.sciallauthapi.domain.models.Credential;
import org.noctisdev.sciallauthapi.domain.models.Token;
import org.noctisdev.sciallauthapi.application.dto.request.CredentialRequest;

import java.util.UUID;

public interface ICredentialService {

    Credential create(CredentialRequest request, Token token, Contact contact);
    Credential find(UUID credentialUuid);
    Credential find(String phoneNumber);
    void update(Credential credential);

}
