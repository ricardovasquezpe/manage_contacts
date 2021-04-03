package com.test.managecontacts.usecases.contact;

import com.test.managecontacts.entity.Contact;

import java.util.List;

public class GetContactUseCase {
    private ContactAdapter adapter;

    public GetContactUseCase(ContactAdapter adapter) {
        this.adapter = adapter;
    }

    public Contact get(Long id) {
        return adapter.getContactById(id);
    }
}
