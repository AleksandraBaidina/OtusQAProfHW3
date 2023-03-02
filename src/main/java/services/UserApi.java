package services;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import specefication.Specification;
import dto.User;

public class UserApi extends Specification {

  public ValidatableResponse logInUser(User user) {
    return given()
        .spec(getBaseSpec())
        .queryParam("username", user.getUsername())
        .queryParam("password", user.getPassword())
        .when()
        .get("/user/login")
        .then();
  }

  public ValidatableResponse createUser(User user) {
    return given()
        .spec(getBaseSpec())
        .body(user)
        .when()
        .post("/user")
        .then();
  }

  public ValidatableResponse createUserWithoutBody() {
    return given()
        .spec(getBaseSpec())
        .when()
        .post("/user")
        .then();
  }


  public User getUserByName(String userName) {

    return given()
        .spec(getBaseSpec())
        .pathParam("username", userName)
        .when()
        .get("/user/{username}")
        .then().statusCode(200).extract().body().as(User.class);
  }

  public ValidatableResponse getUserByNameResponse(String userName) {

    return given()
        .spec(getBaseSpec())
        .pathParam("username", userName)
        .when()
        .get("/user/{username}")
        .then();
  }

  public Response deleteUser(String userName) {
    return given()
        .spec(getBaseSpec())
        .pathParam("username", userName)
        .delete("/delete/{username}");
  }
}
