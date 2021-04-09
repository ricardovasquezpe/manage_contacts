package com.test.managecontacts.rest;

import com.test.managecontacts.entity.Contact;
import com.test.managecontacts.rest.dto.ContactDto;
import com.test.managecontacts.rest.mapper.ContactDtoMapper;
import com.test.managecontacts.usecases.contact.GetAllContactsUseCase;
import com.test.managecontacts.usescases.security.LoginUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/security")
public class LoginController {

    @Autowired
    private LoginUseCase loginUseCase;

    @PostMapping("/login")
    public ResponseEntity<String> login() {
        String token = loginUseCase.login();
        return new ResponseEntity<String>(token, HttpStatus.OK);
    }
}
