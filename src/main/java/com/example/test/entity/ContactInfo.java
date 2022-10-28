package com.example.test.entity;

import com.example.test.model.Name;
import com.example.test.model.Phone;

import java.util.List;

/**
 * A Projection for the {@link Contact} entity
 */
public interface ContactInfo {

    Name getName();

    List<Phone> getPhone();
}