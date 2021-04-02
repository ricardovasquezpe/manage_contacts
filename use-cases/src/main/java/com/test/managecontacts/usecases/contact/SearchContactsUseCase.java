package com.test.managecontacts.usecases.contact;

import com.test.managecontacts.entity.Contact;

import java.util.Date;
import java.util.List;

public class SearchContactsUseCase {
    private ContactAdapter adapter;

    public SearchContactsUseCase(ContactAdapter adapter) {
        this.adapter = adapter;
    }

    public List<Contact> search(String name, Date bithDate){
        return adapter.searchContacts(name, bithDate);
    }
}
