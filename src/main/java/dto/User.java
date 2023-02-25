package mpack;

import static org.apache.commons.lang3.RandomUtils.nextInt;

import com.github.javafaker.Faker;
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
    Faker faker = new Faker();
    User user = User.builder()
        .id(faker.number().numberBetween(1, 10))
        .username(faker.name().username())
        .firstName(faker.name().firstName())
        .lastName(faker.name().lastName())
        .email(faker.internet().emailAddress())
        .password(faker.internet().password())
        .phone(faker.phoneNumber().cellPhone())
        .userStatus(nextInt())
        .build();
    return user;
  }
}

