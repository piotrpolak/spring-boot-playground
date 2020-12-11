package ro.polak.springbootplayground.datafixtures;

import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.polak.springboot.datafixtures.DataFixture;
import ro.polak.springboot.datafixtures.DataFixtureSet;
import ro.polak.springbootplayground.model.Language;
import ro.polak.springbootplayground.repository.LanguageRepository;

@Component
@RequiredArgsConstructor
public class LanguageDataFixture implements DataFixture {

  private final LanguageRepository languageRepository;

  @Override
  public DataFixtureSet getSet() {
    return DataFixtureSet.DICTIONARY;
  }

  @Override
  public boolean canBeApplied() {
    return languageRepository.count() == 0;
  }

  @Override
  public void apply() {
    languageRepository.saveAll(
        Arrays.asList(
            new Language("en-US"),
            new Language("en-GB"),
            new Language("pl-PL")
        ));
  }
}
