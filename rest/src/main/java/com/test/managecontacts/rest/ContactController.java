package com.test.managecontacts.rest;

import com.test.managecontacts.rest.dto.ContactDto;
import com.test.managecontacts.rest.mapper.ContactDtoMapper;
import com.test.managecontacts.rest.mapper.ContactRequestMapper;
import com.test.managecontacts.usecases.contact.GetAllContactsUseCase;
import com.test.managecontacts.entity.Contact;
import com.test.managecontacts.usecases.contact.InsertContactUseCase;
import com.test.managecontacts.usecases.contact.SearchContactsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private GetAllContactsUseCase getAllContactsUseCase;

    @Autowired
    private InsertContactUseCase insertContactUseCase;

    @Autowired
    private SearchContactsUseCase searchContactsUseCase;

    @GetMapping
    public ResponseEntity<List<ContactDto>> getAllContacts() {
        List<Contact> list = getAllContactsUseCase.get();
        List<ContactDto> listDto = ContactDtoMapper.mapListEntityToDto(list);
        return new ResponseEntity<List<ContactDto>>(listDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ContactDto> addContact(@RequestBody ContactRequest contactRequest) {
        Contact contactResponse = insertContactUseCase.insert(ContactRequestMapper.mapRequestToEntity(contactRequest));
        return new ResponseEntity<ContactDto>(ContactDtoMapper.mapEntityToDto(contactResponse), HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ContactDto>> searchContacts(
            @RequestParam(value = "name", required = true) String name) {
        List<Contact> list = searchContactsUseCase.search(name, null);
        List<ContactDto> listDto = ContactDtoMapper.mapListEntityToDto(list);
        return new ResponseEntity<List<ContactDto>>(listDto, HttpStatus.OK);
    }
}
