package com.test.managecontacts.usecases.contact;

import com.test.managecontacts.entity.Contact;

public class UpdateContactUseCase {

    private ContactAdapter adapter;

    public UpdateContactUseCase(ContactAdapter adapter) {
        this.adapter = adapter;
    }

    public Contact update(Long id, Contact contact){
        Contact result = adapter.updateContactById(id, contact);
        return result;
    }
}
