package org.noctisdev.sciallauthapi.infraestructure.dto.response;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public record ContactResponse(
        UUID contactUuid,
        String phoneNumber,
        String email,
        LocalDate createdAt
) implements Serializable { }