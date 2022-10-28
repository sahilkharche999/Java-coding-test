package com.example.test.controller;

import com.example.test.entity.Contact;
import com.example.test.service.ContactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/contacts")
@RequiredArgsConstructor
@Slf4j
public class ContactController {

    private final ContactService service;

    @GetMapping
    public ResponseEntity<List<Contact>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Contact> save(@RequestBody Contact contact) {
        return ResponseEntity.status(201).body(service.save(contact));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> update(@PathVariable("id") Long id, @RequestBody Contact contact) {
        return ResponseEntity.ok(service.update(id, contact));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
