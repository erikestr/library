package com.decsef.library.dao;

import com.decsef.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RepositoryRestResource
public interface BookRepository extends JpaRepository<Book, UUID> {
    Book findAllById(UUID uuid);

    @Transactional
    @Modifying
    @Query("UPDATE Book b SET b.quantity = ?1 WHERE b.id = ?2")
    void setBookQuantity(int quantity, UUID uuid);
}
