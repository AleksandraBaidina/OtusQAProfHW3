import static org.hamcrest.Matchers.equalTo;

import dto.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.UserApi;
import specefication.Specification;

public class NegativeUserTest extends Specification {

  private UserApi userApi = new UserApi();
  private User rndUser;

  @BeforeEach
  public void setUp() {
    rndUser = User.getRandom();
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
}
