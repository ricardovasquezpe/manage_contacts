package com.test.managecontacts.controller;

import com.test.managecontacts.model.contact.Contact;
import com.test.managecontacts.payload.ContactRequest;
import com.test.managecontacts.payload.ContactResponse;
import com.test.managecontacts.service.IcontactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private IcontactService contactService;

    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> response = contactService.getAllContacts();
        return new ResponseEntity<List<Contact>>(response, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Contact>> getAllContactsByZipCode(@RequestParam String postalCode) {
        List<Contact> response = contactService.getAllContactsByPostalCode(postalCode);
        return new ResponseEntity<List<Contact>>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ContactResponse> addNewContact(@Valid @RequestBody ContactRequest contactRequest) {
        ContactResponse contactResponse = contactService.addContact(contactRequest);
        return new ResponseEntity<ContactResponse>(contactResponse, HttpStatus.CREATED);
    }
}
