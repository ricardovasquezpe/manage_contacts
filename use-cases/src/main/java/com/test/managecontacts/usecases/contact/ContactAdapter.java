package com.test.managecontacts.usecases.contact;

import com.test.managecontacts.entity.Contact;

import java.util.Date;
import java.util.List;

public interface ContactAdapter {
    List<Contact> getAllContacts();

    Contact insertContact(Contact contact);

    List<Contact> searchContacts(String name, Date birthDate);

    Contact getContactById(Long id);

    Contact updateContactById(Long id, Contact contact);
}
