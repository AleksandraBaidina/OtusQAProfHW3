import org.junit.jupiter.api.BeforeEach;
import specefication.Specification;
import dto.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.UserApi;


public class PositiveUserTest extends Specification {

  private UserApi userApi = new UserApi();
  private User rndUser;

  @BeforeEach
  public void setUp() {
    rndUser = User.getRandom();
  }

  @Test
  public void createUser() {
    userApi.createUser(rndUser);
    User user2 = userApi.getUserByName(rndUser.username);
    Assertions.assertEquals(user2, rndUser);
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
