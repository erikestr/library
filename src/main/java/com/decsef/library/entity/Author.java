package com.decsef.library.entity;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Author {

    @Id
    @Generated
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
    private Date dateBorn;

    @Column(name = "date_death")
    private Date dateDeath;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "education")
    private String education;

    @Column(name = "remarkable_work")
    private String remarkableWork;

    public Author(UUID id, String firstName, String lastName, String nationality, String bornCountry, String bornState, String bornCity, Date dateBorn, Date dateDeath, String occupation, String education, String remarkableWork) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.bornCountry = bornCountry;
        this.bornState = bornState;
        this.bornCity = bornCity;
        this.dateBorn = dateBorn;
        this.dateDeath = dateDeath;
        this.occupation = occupation;
        this.education = education;
        this.remarkableWork = remarkableWork;
    }

    public Author() {

    }
}
