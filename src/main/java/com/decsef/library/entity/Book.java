package com.decsef.library.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Book {
    @Id
//    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    @OneToMany(mappedBy = "bookId")
    private List<Loans> loans;

    @ManyToOne
    @JoinColumn
    private Editorial editorial;

    @ManyToOne
    @JoinColumn
    private Author author;

    @Column(name = "year", nullable = false)
    private String year;

    @Column(name = "tittle", nullable = false)
    private String tittle;

    @Column(name = "edition", nullable = false)
    private String edition;

    @Column(name = "pages", nullable = false)
    private int pages;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "quantity")
    private String quantity;

    public Book(UUID id, String year, String tittle, String edition, int pages) {
        this.id = id;
        this.year = year;
        this.tittle = tittle;
        this.edition = edition;
        this.pages = pages;
    }

    public Book() {

    }
}
