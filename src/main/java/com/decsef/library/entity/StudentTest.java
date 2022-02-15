package com.decsef.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data

public class StudentTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "items")
    private int items;

    @Column(name = "status")
    private boolean status;

    public StudentTest(String name, String lastName, String address, boolean status) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.status = status;
    }

    public StudentTest() {

    }
}
