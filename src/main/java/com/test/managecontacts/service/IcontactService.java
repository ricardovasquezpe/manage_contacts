package com.test.managecontacts.service;

import com.test.managecontacts.model.contact.Contact;
import com.test.managecontacts.payload.ContactRequest;
import com.test.managecontacts.payload.ContactResponse;

import java.util.List;

public interface IcontactService {

    List<Contact> getAllContacts();

    List<Contact> getAllContactsByPostalCode(String postalCode);

    ContactResponse addContact(ContactRequest contact);

}
