package specefication;

import static io.restassured.http.ContentType.JSON;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Specification {
  private static final String BASE_URL = "https://petstore.swagger.io/v2";

  protected static RequestSpecification getBaseSpec() {
    return new RequestSpecBuilder()
        .setContentType(JSON)
        .setBaseUri(BASE_URL)
        .build();
  }
}
