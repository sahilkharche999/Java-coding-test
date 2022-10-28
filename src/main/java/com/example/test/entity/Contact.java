package com.example.test.entity;

import com.example.test.model.Address;
import com.example.test.model.Name;
import com.example.test.model.Phone;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@TypeDefs({ @TypeDef(name = "json", typeClass = JsonStringType.class)})
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Type(type = "json")
    @Column(columnDefinition = "TEXT")
    private Name name;

    @Type(type = "json")
    @Column(columnDefinition = "TEXT")
    private Address address;

    @Type(type = "json")
    @Column(columnDefinition = "TEXT")
    private List<Phone> phone;

    @Column(name = "email")
    private String email;
}
