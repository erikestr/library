package com.decsef.library.dao;

import com.decsef.library.entity.Editorial;
import com.decsef.library.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@RepositoryRestResource
public interface EditorialRepository extends JpaRepository<Editorial, UUID> {
    Editorial findAllById(UUID uuid);

    Page<Editorial> findById(@RequestParam("uuid") UUID uuid, Pageable pageable);

    Page<Editorial> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
}
