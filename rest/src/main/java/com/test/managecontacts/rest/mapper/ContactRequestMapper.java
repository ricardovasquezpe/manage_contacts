package com.test.managecontacts.rest.mapper;

import com.test.managecontacts.entity.Contact;
import com.test.managecontacts.rest.ContactRequest;
import com.test.managecontacts.rest.dto.ContactDto;

public class ContactRequestMapper {

    public static Contact mapRequestToEntity(ContactRequest request){
        Contact contact = new Contact();
        contact.setFullName(request.getFullName());
        contact.setBirthDate(request.getBirthDate());

        return contact;
    }
}
