package org.noctisdev.sciallauthapi.application.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class JwtResponse {
    private UUID userUuid;
    private String accessToken;
    private String refreshToken;
}
