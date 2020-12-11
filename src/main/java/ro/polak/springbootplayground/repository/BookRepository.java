package ro.polak.springbootplayground.repository;

import org.springframework.data.repository.CrudRepository;
import ro.polak.springbootplayground.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
