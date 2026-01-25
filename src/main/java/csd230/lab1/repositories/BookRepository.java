package csd230.lab1.repositories;

import csd230.lab1.entities.BookEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
