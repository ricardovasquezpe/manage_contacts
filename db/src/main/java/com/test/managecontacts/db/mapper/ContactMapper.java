package com.test.managecontacts.db.mapper;

import com.test.managecontacts.db.model.ContactModel;
import com.test.managecontacts.entity.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactMapper {

    public static List<Contact> convertListModelToEntity(List<ContactModel> list) {
        List<Contact> listEntity = new ArrayList<Contact>();

        for(ContactModel model: list){
            listEntity.add(convertModelToEntity(model));
        }

        return listEntity;
    }

    public static Contact convertModelToEntity(ContactModel model) {
        Contact contact = new Contact();
        contact.setId(model.getId());
        contact.setFullName(model.getFullName());
        contact.setBirthDate(model.getBirthDate());

        return contact;
    }

    public static ContactModel convertEntityToModel(Contact entity) {
        ContactModel model = new ContactModel();

        if (entity.getId() != null) {
            model.setId(entity.getId());
        }
        model.setFullName(entity.getFullName());
        model.setBirthDate(entity.getBirthDate());

        return model;
    }
}
