package com.trains.users;

import com.google.common.base.Objects;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import java.util.UUID;
import static com.google.common.base.Preconditions.checkArgument;

@Slf4j
public class User {
    @Getter
    @Setter
    protected String firstName;
    @Getter
    @Setter
    protected String surname;
    @Getter
    protected int age;

    public User(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    public static User of(String firstName, String surname) {
        return new User(firstName, surname);
    }

    public void setAge(int age) {
        checkArgument(age > 0, "age cannot be less than one");
        this.age = age;
        log.info("age changed in com.trains.users.User with firstName {}", this.firstName);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("\n\n\nfirstName", firstName)
                .add("\nsurname", surname)
                .add("\nage", age)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equal(firstName, user.firstName) &&
                Objects.equal(surname, user.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(firstName, surname, age);
    }
}