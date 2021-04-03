package com.test.managecontacts.usecases.contact;

import com.test.managecontacts.entity.Contact;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MultiSearchUseCase {
    private ContactAdapter adapter;

    public MultiSearchUseCase(ContactAdapter adapter) {
        this.adapter = adapter;
    }

    public List<Contact> multiSearch(Map<String, Object> params){
        return adapter.multiSearchContacts(params);
    }
}
