package com.test.managecontacts.repository;

import com.test.managecontacts.model.contact.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{

    List<Contact> findByAddressId(@NotBlank Long addressId);

}
