package com.decsef.library.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Editorial {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "date_foundation", nullable = false)
    private Date dateFoundation;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "editorial")
    private Set<Book> books;
}
