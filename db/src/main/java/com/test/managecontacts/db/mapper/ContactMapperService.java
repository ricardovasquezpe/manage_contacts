package com.test.managecontacts.db.mapper;

import com.test.managecontacts.db.model.ContactModel;
import com.test.managecontacts.entity.Contact;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ContactMapperService {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateContactFromEntity(Contact entity, @MappingTarget ContactModel model);

}
