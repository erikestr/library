package com.decsef.library.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "book")
@Data
public class Book {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "editorial_id")
    private Editorial editorial;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Column(name = "year", nullable = false)
    private String year;

    @Column(name = "tittle", nullable = false)
    private String tittle;

    @Column(name = "edition", nullable = false)
    private String edition;

    @Column(name = "pages", nullable = false)
    private String pages;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "quantity")
    private String quantity;
}
