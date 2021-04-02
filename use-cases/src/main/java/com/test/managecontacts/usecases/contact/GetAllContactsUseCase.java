package com.test.managecontacts.usecases.contact;

import com.test.managecontacts.entity.Contact;

import java.util.List;

public class GetAllContactsUseCase {
    private ContactAdapter adapter;

    public GetAllContactsUseCase(ContactAdapter adapter) {
        this.adapter = adapter;
    }

    public List<Contact> get() {
        return adapter.getAllContacts();
    }
}
