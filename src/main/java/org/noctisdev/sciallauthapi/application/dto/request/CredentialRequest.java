package org.noctisdev.sciallauthapi.application.dto.request;

import org.noctisdev.sciallauthapi.domain.events.EventType;

import java.util.UUID;

public record CredentialRequest(
    EventType type,
    UUID contactUuid,
    String password
) {}
