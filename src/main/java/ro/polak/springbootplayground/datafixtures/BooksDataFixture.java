package ro.polak.springbootplayground.datafixtures;

import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.polak.springboot.datafixtures.DataFixture;
import ro.polak.springboot.datafixtures.DataFixtureSet;
import ro.polak.springbootplayground.model.Book;
import ro.polak.springbootplayground.model.Language;
import ro.polak.springbootplayground.repository.BookRepository;
import ro.polak.springbootplayground.repository.LanguageRepository;

@Component
@RequiredArgsConstructor
public class BooksDataFixture implements DataFixture {

  private final LanguageRepository languageRepository;
  private final BookRepository bookRepository;

  @Override
  public DataFixtureSet getSet() {
    return DataFixtureSet.DEMO;
  }

  @Override
  public boolean canBeApplied() {
    return bookRepository.count() == 0;
  }

  @Override
  public void apply() {

    Language enUs = languageRepository.findById("en-US").orElseThrow(() -> new IllegalStateException("It looks like LanguageDataFixture was not executed."));

    bookRepository.saveAll(
        Arrays.asList(
            Book.builder()
                .title("Effective Java 3rd Edition")
                .isbn("978-0134685991")
                .language(enUs)
                .build(),
            Book.builder()
                .title("Clean Code: A Handbook of Agile Software Craftsmanship 1st Edition")
                .isbn("978-0132350884")
                .language(enUs)
                .build()
        ));
  }
}
