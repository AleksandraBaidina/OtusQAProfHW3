package dto;

import static org.apache.commons.lang3.RandomUtils.nextInt;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return id == user.id && userStatus == user.userStatus && username.equals(user.username) && firstName.equals(user.firstName)
        && lastName.equals(user.lastName) && email.equals(user.email) && password.equals(user.password) && phone.equals(user.phone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, firstName, lastName, email, password, phone, userStatus);
  }

  @Override
  public String toString() {
    return "User{"
        +
        "id=" + id
        +
        ", username='" + username + '\''
        +
        ", firstName='" + firstName + '\''
        +
        ", lastName='" + lastName + '\''
        +
        ", email='" + email + '\''
        +
        ", password='" + password + '\''
        +
        ", phone='" + phone + '\''
        +
        ", userStatus=" + userStatus
        +
        '}';
  }
}

