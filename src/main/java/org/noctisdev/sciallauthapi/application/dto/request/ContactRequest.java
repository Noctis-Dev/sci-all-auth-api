package org.noctisdev.sciallauthapi.application.dto.request;

import org.noctisdev.sciallauthapi.domain.events.EventType;

public record ContactRequest(
    EventType type,
    String phoneNumber,
    String email
) { }