package com.test.managecontacts.rest.mapper;

import com.test.managecontacts.entity.Contact;
import com.test.managecontacts.rest.dto.ContactDto;

import java.util.ArrayList;
import java.util.List;

public class ContactDtoMapper {
    public static List<ContactDto> mapListEntityToDto(List<Contact> list){
        List<ContactDto> listDto = new ArrayList();
        for (final Contact contact : list) {
            listDto.add(mapEntityToDto(contact));
        }

        return listDto;
    }

    public static ContactDto mapEntityToDto(Contact model){
        ContactDto contactDto = new ContactDto();
        contactDto.setId(model.getId());
        contactDto.setFullName(model.getFullName());
        contactDto.setBirthDate(model.getBirthDate());

        return contactDto;
    }
}
