package csd230.lab1.repositories;

import csd230.lab1.entities.BookEntity;
import csd230.lab1.pojos.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    List<Book> findByIsbn(String isbn);
    Book findById(long id);
    @Query("SELECT copies FROM BookEntity WHERE copies < 10")
    List<Book> FindByCopies(int copies);
}