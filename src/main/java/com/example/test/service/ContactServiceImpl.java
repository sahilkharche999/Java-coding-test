package com.example.test.service;

import com.example.test.entity.Contact;
import com.example.test.entity.ContactInfo;
import com.example.test.model.CallList;
import com.example.test.model.Phone;
import com.example.test.model.PhoneType;
import com.example.test.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository repository;

    @Override
    public List<Contact> getAll() {
        return repository.findAll();
    }

    @Override
    public Contact save(Contact contact) {
        return repository.save(contact);
    }

    @Override
    public Contact update(Long id, Contact contact) {
        Contact c = repository.findById(id).orElse(null);
        if (c == null) {
            return null;
        }
        c.setName(contact.getName());
        c.setEmail(contact.getEmail());
        c.setPhone(contact.getPhone());
        c.setAddress(contact.getAddress());
        return repository.save(c);
    }

    @Override
    public Contact getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<CallList> getCallList() {
        List<ContactInfo> contactInfos = repository.getCallList();
        List<CallList> response = new ArrayList<>();

        contactInfos.parallelStream().forEach(contactInfo -> {
            List<Phone> phones = contactInfo.getPhone();
            for (var phone : phones) {
                if (phone.getType().equals(PhoneType.home)) {
                    response.add(CallList.builder().name(contactInfo.getName()).phone(phone.getNumber()).build());
                }
            }
        });
        return response;
    }
}
