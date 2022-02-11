package com.decsef.library.dao;

import com.decsef.library.entity.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(path = "loans")
public interface LoansRepository extends JpaRepository<Loans, UUID> {
}
