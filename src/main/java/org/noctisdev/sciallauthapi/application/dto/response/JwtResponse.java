package org.noctisdev.sciallauthapi.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JwtResponse {
    private String accessToken;
    private String refreshToken;
}