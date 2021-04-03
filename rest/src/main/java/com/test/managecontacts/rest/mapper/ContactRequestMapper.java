package com.test.managecontacts.rest.mapper;

import com.test.managecontacts.entity.Contact;
import com.test.managecontacts.rest.payload.ContactRequest;
import com.test.managecontacts.rest.payload.UpdateContactRequest;

public class ContactRequestMapper {

    public static Contact mapRequestToEntity(ContactRequest request){
        Contact contact = new Contact();
        contact.setFullName(request.getFullName());
        contact.setBirthDate(request.getBirthDate());

        return contact;
    }

    public static Contact contactUpdateRequestToEntity(UpdateContactRequest request){
        Contact contact = new Contact();
        contact.setFullName(request.getFullName());

        return contact;
    }
}
