# Spring Boot Playground

This playground project is intended to be a demonstration of
the [Spring Boot Data Fixtures](https://github.com/piotrpolak/spring-boot-data-fixtures) project and additionally be
blueprint/reference for the fresh Spring Boot services.

The project is intended to be developer friendly, highly testable and aligned with the API First principe. Individual
features are listed below.

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

- Removed `@Api*` annotations - these annotations come from Swagger 2.0 package. When using OpenAPI 3.0 to generate the
  code, these annotations are not very useful and might lose come context (Swagger 2.0 VS OpenAPI 3.0). These
  annotations are only useful when Swagger 2.0 file is generated from the code - which is against API First principle.
  Assuming that OpenAPI definition is already part of the project, these annotations provide no extra value forcing you
  to add additional dependency at the same time.
- Removed `Generated` annotations
- Added Lombok `@Data` annotation to models and removed `hashCode` and `equals` methods,
  moved `vendorExtensions.x-extra-annotation` from getter to property name
- Removed unnecessary code comments

## Testing

The application is tested using integration tests against a running application. The application uses a real Postgres
database started using TestContainers. 