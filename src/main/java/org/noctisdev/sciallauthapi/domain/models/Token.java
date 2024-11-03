package org.noctisdev.sciallauthapi.domain.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.noctisdev.sciallauthapi.domain.models.enums.TokenType;

import java.time.LocalDate;

@Getter @Setter
public class Token {
    private Long id;

    @NotBlank
    private String token;

    @NotNull
    private TokenType tokenType;

    @NotNull
    private LocalDate expirationDate;

    @NotNull
    private TokenSetting tokenSetting;
}