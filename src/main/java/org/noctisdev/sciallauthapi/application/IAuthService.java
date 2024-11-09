package org.noctisdev.sciallauthapi.application;

import org.noctisdev.sciallauthapi.application.dto.BaseResponse;
import org.noctisdev.sciallauthapi.application.dto.request.CredentialRequest;

import java.util.UUID;

public interface IAuthService {

    BaseResponse signUp(CredentialRequest request);
    BaseResponse verifyToken(String token, UUID credentialUuid);

}
