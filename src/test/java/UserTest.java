import static org.hamcrest.Matchers.equalTo;

import mpack.Specification;
import mpack.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.UserApi;

public class UserTest extends Specification {

  UserApi userApi = new UserApi();
  User rndUser;


  @BeforeEach
  public void setUp() {
    rndUser = User.getRandom();
  }

  @Test
  public void createUser()
  //just test, that createUser response is OK
  // to test that created user is the same, we test it in getUserTest().
  {
    userApi.logInUser(rndUser);
    userApi.createUser(rndUser)
        .statusCode(200)
        .body("code", equalTo(200))
        .body("type", equalTo("unknown"))
        .body("message", Matchers.notNullValue())
        .contentType("application/json");
  }

  @Test
  public void createUserWithoutBody() {
    userApi.logInUser(rndUser);
    userApi.createUserWithoutBody()
        .statusCode(405)
        .body("code", equalTo(405))
        .body("type", equalTo("unknown"))
        .body("message", equalTo("no data"));
  }

  @Test
  public void getUserByName() {

    userApi.createUser(rndUser);

    User resUser = userApi.getUserByName(rndUser.getUsername());
    Assertions.assertEquals(resUser, rndUser);
  }

  @Test
  public void getUserByNameNonExistingUser() {

    userApi.getUserByNameResponse(RandomStringUtils.randomAlphabetic(5))
        .statusCode(404);
  }

  @AfterEach
  public void tearDown() {
    userApi.deleteUser(rndUser.getUsername());
  }
}
