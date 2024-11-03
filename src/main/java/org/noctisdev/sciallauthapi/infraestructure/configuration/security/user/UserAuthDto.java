package org.noctisdev.sciallauthapi.infraestructure.configuration.security.user;

import lombok.Data;

@Data
public class UserAuthDto {
    private String phoneNumber;
    private String password;
}
