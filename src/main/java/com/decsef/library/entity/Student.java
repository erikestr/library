package com.decsef.library.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Student {

    @Id
//    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "items")
    private int items;

    @Column(name = "status")
    private boolean status;

    public Student(UUID id, String firstName, String lastName, String address, boolean status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.status = status;
    }

    public Student() {

    }
}
