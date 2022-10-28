package com.example.test;

import com.example.test.entity.Contact;
import com.example.test.model.Address;
import com.example.test.model.Name;
import com.example.test.model.Phone;
import com.example.test.model.PhoneType;
import com.example.test.service.ContactService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContactServiceTest {

    @Autowired
    ContactService contactService;

    @Test
    @Order(1)
    public void saveTest() {
        Contact contact = new Contact();
        Name name = new Name("Ben", "Max", "Tennison");
        Address address = new Address("1", "Downtown", "Texas", "49081");
        List<Phone> phones = new ArrayList<>(1);
        phones.add(new Phone("8768", PhoneType.home));

        contact.setName(name);
        contact.setAddress(address);
        contact.setPhone(phones);
        contact.setEmail("BenTen@10.com");

        Contact res = contactService.save(contact);

        Assertions.assertTrue(res.getId() > 0);
    }

    @Test
    @Order(2)
    public void getByIdTest() {
        Contact res = contactService.getById(1L);
        Assertions.assertEquals(1L, res.getId());
    }

    @Test
    @Order(3)
    public void updateTest() {
        Contact res = contactService.getById(1L);
        Assertions.assertTrue(res.getName().getFirst().equals("Ben"));

        res.getName().setFirst("Gwenn");
        res = contactService.update(res.getId(), res);

        Assertions.assertTrue(res.getName().getFirst().equals("Gwenn"));
    }

    @Test
    @Order(4)
    public void getAllTest() {
        Assertions.assertEquals(1, contactService.getAll().size());
    }

    @Test
    @Order(5)
    public void getCallListTest() {
        Assertions.assertEquals(1, contactService.getCallList().size());
    }


    @Test
    @Order(6)
    public void deleteTest() {
        Assertions.assertEquals(1, contactService.getAll().size());
        contactService.deleteById(1L);
        Assertions.assertEquals(0, contactService.getAll().size());
    }

}
