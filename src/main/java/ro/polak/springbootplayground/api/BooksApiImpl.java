package ro.polak.springbootplayground.api;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ro.polak.springbootplayground.api.dto.BookDto;
import ro.polak.springbootplayground.api.dto.BooksDto;

@RestController
public class BooksApiImpl implements BooksApi {

  @Override
  public ResponseEntity<Void> createBook(@Valid BookDto body) {
    // FIXME missing implementation
    return null;
  }

  @Override
  public ResponseEntity<BookDto> getBookById(String bookId) {
    // FIXME missing implementation
    return null;
  }

  @Override
  public ResponseEntity<BooksDto> listBooks(@Valid Optional<Integer> limit) {
    // FIXME missing implementation
    return null;
  }
}
