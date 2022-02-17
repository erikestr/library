package com.decsef.library.dao;

import com.decsef.library.entity.Author;
import com.decsef.library.entity.Editorial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@RepositoryRestResource
public interface AuthorRepository extends JpaRepository<Author, UUID> {
    Author findAllById(UUID uuid);

    Page<Author> findById(@RequestParam("uuid") UUID uuid, Pageable pageable);

    Page<Author> findByFirstNameContaining(@RequestParam("name") String name, Pageable pageable);
}
