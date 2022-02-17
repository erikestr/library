package com.decsef.library.dto;

import com.decsef.library.entity.Author;
import com.decsef.library.entity.Book;
import com.decsef.library.entity.Editorial;
import lombok.Data;

@Data
public class Books {

    private Book book;
    private Editorial editorial;
    private Author author;
}
