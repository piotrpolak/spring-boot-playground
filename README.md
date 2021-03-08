# Spring Boot Playground

## Spring boot data fixtures demo

The demonstration of the [Spring Boot Data Fixtures](https://github.com/piotrpolak/spring-boot-data-fixtures).

Sources:
- [Initial `LanguageDataFixture`](../../tree/master/src/main/java/ro/polak/springbootplayground/datafixtures/LanguageDataFixture)
- [Demo `BooksDataFixture`](../../tree/master/src/main/java/ro/polak/springbootplayground/datafixtures/BooksDataFixture.java)
- [Data fixtures tests](../../tree/master/src/test/java/ro/polak/springbootplayground/DataFixturesTest.java)

## Running the project locally

```bash
mvn spring-boot:run -PswaggerUI
```

- Swagger UI: http://localhost:8080/swagger-ui/index.html

## API First approach

The DTO and controller interfaces are generated out of the swagger.yml definition by using
https://github.com/OpenAPITools/openapi-generator.

Selected code templates are copied and customized. The original ones can be found at https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator/src/main/resources

The full list of the generator options can be found at https://openapi-generator.tech/docs/generators/spring/

Changes comparing to the original templates:
- Removed `@Api*` annotations (useless Swagger 2.0 annotations forcing you to add another useless dependency)
- Removed `Generated` annotations
- Added Lombok `@Data` annotation to models and removed `hashCode` and `equals` methods, moved `vendorExtensions.x-extra-annotation` from getter to property name
- Removed unnecessary code comments