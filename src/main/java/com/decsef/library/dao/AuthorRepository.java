package com.decsef.library.dao;

import com.decsef.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource
public interface AuthorRepository extends JpaRepository<Author, UUID> {
    Author findAllById(UUID uuid);
}
