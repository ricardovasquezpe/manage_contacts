package com.test.managecontacts.db;

import com.test.managecontacts.db.model.ContactModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<ContactModel, Long> {
    @Query(value = "SELECT * FROM contacts WHERE full_name LIKE CONCAT('%',:name,'%') AND birth_date > :birthDate", nativeQuery = true)
    List<ContactModel> searchContactByParams(@Param("name") String name, @Param("birthDate") Date bithDate);
}
