package specefication;

import static io.restassured.http.ContentType.JSON;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Specification {
  private static final String CONFIG = "config/config.json";
  protected static final String BASE_URL;

  static {

    if (System.getenv("HOST") != null) {
      BASE_URL = System.getenv("HOST");
    } else {
      JSONObject json = null;
      try {
        InputStream stream = new FileInputStream(CONFIG);
        String jsonString = IOUtils.toString(stream, StandardCharsets.UTF_8);
        json = new JSONObject(jsonString);
        BASE_URL = json.getString("host");
      } catch (Exception e) {
        System.out.println("Error while parsing " + CONFIG + ": " + e.getMessage());
        throw new RuntimeException(e);
      }
    }
  }

  protected static RequestSpecification getBaseSpec() {
    return new RequestSpecBuilder()
        .setContentType(JSON)
        .setBaseUri(BASE_URL)
        .build();
  }
}
