package ro.polak.springbootplayground.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.ISBN;

import static org.hibernate.validator.constraints.ISBN.Type.ISBN_13;

@Entity
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
public class Book {

  @Id
  @GeneratedValue
  private long id;

  @ISBN(type = ISBN_13)
  @Column(length = 16)
  private String isbn;

  private String title;

  @ManyToOne
  private Language language;
}
