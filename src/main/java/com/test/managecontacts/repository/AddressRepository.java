package com.test.managecontacts.repository;

import com.test.managecontacts.model.contact.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Address findByPostalCode(String postalCode);

}
