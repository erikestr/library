package com.decsef.library.dao;

import com.decsef.library.entity.Author;
import com.decsef.library.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@RepositoryRestResource
public interface BookRepository extends JpaRepository<Book, UUID> {
    Book findAllById(UUID uuid);

    Page<Book> findById(@RequestParam("uuid") UUID uuid, Pageable pageable);

    Page<Book> findByTittleContaining(@RequestParam("name") String name, Pageable pageable);

    @Transactional
    @Modifying(flushAutomatically = true)
    @Query("UPDATE Book b SET b.quantity = ?1 WHERE b.id = ?2")
    void setBookQuantity(int quantity, UUID uuid);
}
