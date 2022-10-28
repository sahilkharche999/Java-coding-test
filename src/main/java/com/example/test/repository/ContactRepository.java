package com.example.test.repository;

import com.example.test.entity.Contact;
import com.example.test.entity.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query("SELECT c.name as name, c.phone as phone FROM Contact c")
    List<ContactInfo> getCallList();
}
