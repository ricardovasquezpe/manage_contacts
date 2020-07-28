package com.test.managecontacts.service;

import com.test.managecontacts.model.contact.Address;
import com.test.managecontacts.model.contact.Contact;
import com.test.managecontacts.payload.ContactRequest;
import com.test.managecontacts.payload.ContactResponse;
import com.test.managecontacts.repository.AddressRepository;
import com.test.managecontacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
class ContactService implements IcontactService {
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Contact> getAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts;
    }

    @Cacheable("contacts")
    @Override
    public List<Contact> getAllContactsByPostalCode(String postalCode) {
        Address address = addressRepository.findByPostalCode(postalCode);
        List<Contact> findValidator = new ArrayList<Contact>();
        if(address != null){
            List<Contact> find = contactRepository.findByAddressId(address.getId());
            findValidator = find.size() == 0 ? new ArrayList<Contact>() : find;
        }

        return findValidator;
    }

    @Override
    public ContactResponse addContact(ContactRequest contact) {
        Address newAddress = new Address();
        newAddress.setCity(contact.getAddress().getCity());
        newAddress.setPostalCode(contact.getAddress().getPostalCode());
        Address createdAddress = addressRepository.save(newAddress);

        Contact newContact = new Contact();
        newContact.setFullName(contact.getFullName());
        newContact.setBirthDate(contact.getBirthDate());
        newContact.setAddress(createdAddress);
        Contact createdContact = contactRepository.save(newContact);

        ContactResponse response = new ContactResponse();
        response.setContactId(createdContact.getId());

        return response;
    }

    @CacheEvict(cacheNames="contacts", allEntries=true)
    public void flushCache() {  }

}
