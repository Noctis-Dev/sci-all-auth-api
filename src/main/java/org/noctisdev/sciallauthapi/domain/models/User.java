package org.noctisdev.sciallauthapi.domain.models;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UUID;
import org.noctisdev.sciallauthapi.domain.models.enums.UserStatus;

import java.time.LocalDate;


@Getter @Setter
public class User {
    private Long id;

    @UUID
    @NotNull
    private java.util.UUID userUuid;

    @NotNull
    private LocalDate createdAt;

    private LocalDate activatedAt;

    private LocalDate deletedAt;

    @NotNull
    private UserStatus status;

    @NotNull
    private Contact contact;
}