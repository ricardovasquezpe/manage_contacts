package com.test.managecontacts.db;

import com.test.managecontacts.db.mapper.ContactMapper;
import com.test.managecontacts.db.model.ContactModel;
import com.test.managecontacts.usecases.contact.ContactAdapter;
import com.test.managecontacts.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class ContactAdapterImpl implements ContactAdapter {

    @Autowired
    private ContactRepository contactRepository;

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
    public List<Contact> searchContacts(String name, Date bithDate) {
        List<ContactModel> list = this.contactRepository.searchContactByParams(name);
        return ContactMapper.convertListModelToEntity(list);
    }
}
