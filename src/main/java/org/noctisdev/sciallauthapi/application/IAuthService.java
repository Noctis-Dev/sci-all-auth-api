package org.noctisdev.sciallauthapi.application;

import org.noctisdev.sciallauthapi.infraestructure.dto.BaseResponse;
import org.noctisdev.sciallauthapi.infraestructure.dto.request.CredentialRequest;

import java.util.UUID;

public interface IAuthService {

    BaseResponse signUp(CredentialRequest request);
    BaseResponse verifyToken(String token, UUID credentialUuid);

}
