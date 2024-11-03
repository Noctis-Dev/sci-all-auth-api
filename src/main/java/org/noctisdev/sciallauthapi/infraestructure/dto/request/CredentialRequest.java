package org.noctisdev.sciallauthapi.infraestructure.dto.request;

import java.util.UUID;

public record CredentialRequest(
    UUID contactUuid,
    String password
) {}
