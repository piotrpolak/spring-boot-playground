package ro.polak.springbootplayground;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ro.polak.springboot.datafixtures.DataFixtureLoaderService;
import ro.polak.springboot.datafixtures.DataFixtureSet;
import ro.polak.springbootplayground.repository.BookRepository;
import ro.polak.springbootplayground.repository.LanguageRepository;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This test assumes that the default Spring Boot Data Fixtures configuration is used.
 */
public class DataFixturesTest extends BaseIT {

  @Autowired
  private LanguageRepository languageRepository;

  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private DataFixtureLoaderService dataFixtureLoaderService;

  @Test
  void should_load_initial_language_data_fixture_upon_application_startup() {
    assertThat(languageRepository.count()).isEqualTo(3);
  }

  @Test
  void should_not_load_demo_books_data_fixture_upon_application_startup() {
    assertThat(bookRepository.count()).isEqualTo(0);
  }

  @Test
  void should_be_able_to_load_fixtures_manually() {
    dataFixtureLoaderService.applyBySingleType(DataFixtureSet.DEMO);

    assertThat(bookRepository.count()).isGreaterThan(0);

    bookRepository.deleteAll();
  }
}
