package org.noctisdev.sciallauthapi.infraestructure.controller;

import org.noctisdev.sciallauthapi.application.IAuthService;
import org.noctisdev.sciallauthapi.infraestructure.dto.BaseResponse;
import org.noctisdev.sciallauthapi.infraestructure.dto.request.CredentialRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("credential")
public class CreateCredentialController {

    @Autowired
    private IAuthService service;

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody CredentialRequest request) {
        return service.signUp(request).apply();
    }

}
