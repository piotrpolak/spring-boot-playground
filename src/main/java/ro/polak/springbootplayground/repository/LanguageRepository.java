package ro.polak.springbootplayground.repository;

import org.springframework.data.repository.CrudRepository;
import ro.polak.springbootplayground.model.Language;

public interface LanguageRepository extends CrudRepository<Language, String> {
}
