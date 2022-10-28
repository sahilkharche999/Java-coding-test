package com.example.test.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CallList {

    private Name name;
    private String phone;

}
