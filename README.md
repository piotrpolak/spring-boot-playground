# Spring Boot Playground

The demonstration of the [Spring Boot Data Fixtures](https://github.com/piotrpolak/spring-boot-data-fixtures).

This project can also be used as a reference for a fresh Spring Boot project (blueprint).

## Spring boot data fixtures demo

Sources:

- [Initial `LanguageDataFixture`](../../tree/master/src/main/java/ro/polak/springbootplayground/datafixtures/LanguageDataFixture)
- [Demo `BooksDataFixture`](../../tree/master/src/main/java/ro/polak/springbootplayground/datafixtures/BooksDataFixture.java)
- [Data fixtures tests](../../tree/master/src/test/java/ro/polak/springbootplayground/DataFixturesTest.java)

## Running the project locally

```bash
mvn spring-boot:run -PswaggerUI
```

- Swagger UI: http://localhost:8080/swagger-ui/index.html

## API First approach and OpenAPI generator

The DTOs and controller interfaces are generated out of the `swagger.yml` definition by using
https://github.com/OpenAPITools/openapi-generator.

The code templates are copied and customized. The original ones can be found at
https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator/src/main/resources
The templates were forked at
the [f5151de9fcb35cb58f86df2bb3d948b3ef96cfa8](https://github.com/OpenAPITools/openapi-generator/commit/f5151de9fcb35cb58f86df2bb3d948b3ef96cfa8)
commit.

The full list of the generator options can be found at https://openapi-generator.tech/docs/generators/spring/

Changes comparing to the original templates:

- Removed `@Api*` annotations (useless Swagger 2.0 annotations forcing you to add another useless dependency)
- Removed `Generated` annotations
- Added Lombok `@Data` annotation to models and removed `hashCode` and `equals` methods,
  moved `vendorExtensions.x-extra-annotation` from getter to property name
- Removed unnecessary code comments

## Testing

The application is tested using integration tests against a running application. The application uses a real Postgres
database started using TestContainers. 