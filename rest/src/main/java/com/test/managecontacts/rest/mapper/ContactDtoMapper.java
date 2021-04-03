package com.test.managecontacts.rest.mapper;

import com.test.managecontacts.entity.Contact;
import com.test.managecontacts.rest.dto.ContactDto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class ContactDtoMapper {
    public static final String pattern = "dd/MM/yyyy";

    public static List<ContactDto> mapListEntityToDto(List<Contact> list){
        List<ContactDto> listDto = new ArrayList();
        for (final Contact contact : list) {
            listDto.add(mapEntityToDto(contact));
        }

        return listDto;
    }

    public static ContactDto mapEntityToDto(Contact model){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String date = simpleDateFormat.format(model.getBirthDate());

        ContactDto contactDto = new ContactDto();
        contactDto.setId(model.getId());
        contactDto.setFullName(model.getFullName());
        contactDto.setBirthDate(date);
        contactDto.setPassword(model.getPassword());

        return contactDto;
    }
}
