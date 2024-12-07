package org.noctisdev.sciallauthapi.infraestructure.controller;

import org.noctisdev.sciallauthapi.application.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contact")
public class GetContactController {

    @Autowired
    private IContactService service;

    @GetMapping
    public String get() {
        return "OK";
    }

}
