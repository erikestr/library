package com.decsef.library.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Author {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "nationality", nullable = false)
    private String nationality;

    @Column(name = "born_country", nullable = false)
    private String bornCountry;

    @Column(name = "born_state", nullable = false)
    private String bornState;

    @Column(name = "born_city", nullable = false)
    private String bornCity;

    @Column(name = "date_born", nullable = false)
    private String dateBorn;

    @Column(name = "date_death")
    private String dateDeath;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "education")
    private String education;

    @Column(name = "remarkable_work")
    private String remarkableWork;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private Set<Book> books;
}
