package com.test.managecontacts.usecases.contact;

import com.test.managecontacts.entity.Contact;

public class InsertContactUseCase {
    private ContactAdapter adapter;

    public InsertContactUseCase(ContactAdapter adapter) {
        this.adapter = adapter;
    }

    public Contact insert(Contact contact){
        return adapter.insertContact(contact);
    }
}
