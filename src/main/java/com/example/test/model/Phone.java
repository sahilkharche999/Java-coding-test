package com.example.test.model;

import lombok.Data;

@Data
public class Phone {
    private String number;
    private PhoneType type;

    public Phone(String number, PhoneType type) {
        this.number = number;
        this.type = type;
    }
}
