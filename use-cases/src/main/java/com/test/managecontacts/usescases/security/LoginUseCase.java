package com.test.managecontacts.usescases.security;

import com.test.managecontacts.libreries.jwtoken.JwtTokenProvider;
import com.test.managecontacts.usecases.contact.ContactAdapter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LoginUseCase {
    private ContactAdapter adapter;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public LoginUseCase(ContactAdapter adapter) {
        this.adapter = adapter;
    }

    public String login() {
        return jwtTokenProvider.createToken("test");
    }
}
