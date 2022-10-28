package com.example.test.service;

import com.example.test.entity.Contact;
import com.example.test.model.CallList;

import java.util.List;

public interface ContactService {

    List<Contact> getAll();

    Contact save(Contact contact);

    Contact update(Long id, Contact contact);

    Contact getById(Long id);

    void deleteById(Long id);

    List<CallList> getCallList();

}
