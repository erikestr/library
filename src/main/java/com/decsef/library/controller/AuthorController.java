package com.decsef.library.controller;

import com.decsef.library.entity.Author;
import com.decsef.library.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"https://localhost:4200"})
@RequestMapping("/api/author")
@AllArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public Author registerAuthor(@RequestBody Author author){
        return authorService.registerAuthor(author);
    }

    @DeleteMapping
    public boolean deleteAuthor(@RequestBody Author author){
        return authorService.deleteAuthor(author);
    }

    @PutMapping
    public Author updateAuthor(@RequestBody Author author) {
        return authorService.updateAuthor(author);
    }
}
