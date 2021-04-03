package com.test.managecontacts.db;

import com.test.managecontacts.db.mapper.ContactMapper;
import com.test.managecontacts.db.mapper.ContactMapperService;
import com.test.managecontacts.db.model.ContactModel;
import com.test.managecontacts.usecases.contact.ContactAdapter;
import com.test.managecontacts.entity.Contact;
import com.test.managecontacts.usecases.contact.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ContactAdapterImpl implements ContactAdapter {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ContactMapperService contactMapperService;

    @Override
    public List<Contact> getAllContacts() {
        List<ContactModel> list = this.contactRepository.findAll();
        return ContactMapper.convertListModelToEntity(list);
    }

    @Override
    public Contact insertContact(Contact contact) {
        ContactModel result = this.contactRepository.save(ContactMapper.convertEntityToModel(contact));
        return ContactMapper.convertModelToEntity(result);
    }

    @Override
    public List<Contact> searchContacts(String name, Date birthDate) {
        List<ContactModel> list = this.contactRepository.searchContactByParams(name, birthDate);
        return ContactMapper.convertListModelToEntity(list);
    }

    @Override
    public Contact getContactById(Long id) {
        Optional<ContactModel> result = this.contactRepository.findById(id);
        if(!result.isPresent()){
            throw new ResourceNotFoundException("Contact not found");
        }
        ContactModel model = result.get();
        return ContactMapper.convertModelToEntity(model);
    }

    @Override
    public Contact updateContactById(Long id, Contact contact) {
        Optional<ContactModel> getResult = this.contactRepository.findById(id);
        if(!getResult.isPresent()){
            throw new ResourceNotFoundException("Contact not found");
        }
        ContactModel model = getResult.get();
        contactMapperService.updateContactFromEntity(contact, model);
        ContactModel result = this.contactRepository.save(model);
        return ContactMapper.convertModelToEntity(result);
    }
}
