package com.spakova19.booktracker.repository;

import com.spakova19.booktracker.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long>  {
    Optional<Author> findByName(String name);
}
