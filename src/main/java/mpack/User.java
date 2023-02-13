package mpack;

import static org.apache.commons.lang3.RandomUtils.nextInt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {

  public int id;
  public String username;
  public String firstName;
  public String lastName;
  public String email;
  public String password;
  public String phone;
  public int userStatus;

  public static User getRandom() {
    User user = User.builder()
        .id((nextInt()))
        .username(RandomStringUtils.randomAlphabetic(7))
        .firstName(RandomStringUtils.randomAlphabetic(7))
        .lastName(RandomStringUtils.randomAlphabetic(7))
        .email(RandomStringUtils.randomAlphabetic(6) + '@' + RandomStringUtils.randomAlphabetic(4) + ".com")
        .password(RandomStringUtils.randomAlphabetic(10))
        .phone(RandomStringUtils.randomAlphabetic(11))
        .userStatus((nextInt()))
        .build();
    return user;
  }
}

