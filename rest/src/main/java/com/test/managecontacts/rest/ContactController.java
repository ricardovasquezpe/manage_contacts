package com.test.managecontacts.rest;

import com.test.managecontacts.rest.dto.ContactDto;
import com.test.managecontacts.rest.mapper.ContactDtoMapper;
import com.test.managecontacts.rest.mapper.ContactRequestMapper;
import com.test.managecontacts.rest.payload.ContactRequest;
import com.test.managecontacts.rest.payload.UpdateContactRequest;
import com.test.managecontacts.usecases.contact.*;
import com.test.managecontacts.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private GetAllContactsUseCase getAllContactsUseCase;

    @Autowired
    private InsertContactUseCase insertContactUseCase;

    @Autowired
    private SearchContactsUseCase searchContactsUseCase;

    @Autowired
    private GetContactUseCase getContactUseCase;

    @Autowired
    private UpdateContactUseCase updateContactUseCase;

    @Autowired
    private MultiSearchUseCase multiSearchUseCase;

    @GetMapping
    @CrossOrigin
    public ResponseEntity<List<ContactDto>> getAllContacts() {
        List<Contact> list = getAllContactsUseCase.get();
        List<ContactDto> listDto = ContactDtoMapper.mapListEntityToDto(list);
        return new ResponseEntity<List<ContactDto>>(listDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ContactDto> addContact(@Valid @RequestBody ContactRequest contactRequest) {
        Contact contactResponse = insertContactUseCase.insert(ContactRequestMapper.mapRequestToEntity(contactRequest));
        return new ResponseEntity<ContactDto>(ContactDtoMapper.mapEntityToDto(contactResponse), HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ContactDto>> searchContacts(@RequestParam(value = "name", required = true)
                                                                       String name,
                                                           @RequestParam(value = "birthDate", required = true)
                                                           @DateTimeFormat(pattern="dd-MM-yyyy")
                                                                   Date birthDate) {
        List<Contact> list = searchContactsUseCase.search(name, birthDate);
        List<ContactDto> listDto = ContactDtoMapper.mapListEntityToDto(list);
        return new ResponseEntity<List<ContactDto>>(listDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactDto> getContact(@PathVariable Long id) {
        Contact contact = getContactUseCase.get(id);
        return new ResponseEntity<ContactDto>(ContactDtoMapper.mapEntityToDto(contact), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactDto> updateContact(@PathVariable Long id,
                                                    @Valid @RequestBody UpdateContactRequest updateContactRequest) {
        Contact contact = updateContactUseCase.update(id, ContactRequestMapper.contactUpdateRequestToEntity(updateContactRequest));
        return new ResponseEntity<ContactDto>(ContactDtoMapper.mapEntityToDto(contact), HttpStatus.OK);
    }

    @PostMapping("/multi-search")
    public ResponseEntity<List<ContactDto>> multiSearch(@RequestBody Map<String, Object> payload) {
        List<Contact> list = multiSearchUseCase.multiSearch(payload);
        List<ContactDto> listDto = ContactDtoMapper.mapListEntityToDto(list);
        return new ResponseEntity<List<ContactDto>>(listDto, HttpStatus.OK);
    }
}
