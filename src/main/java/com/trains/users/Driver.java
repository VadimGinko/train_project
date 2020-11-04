package com.trains.users;

import com.google.common.base.Objects;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import static com.google.common.base.Preconditions.checkArgument;

@Slf4j
public final class Driver extends User {
    @Getter private int salary;

    public Driver(String firstName, String surname) {
        super(firstName, surname);
    }

    public static Driver of(String firstName, String surname){return new Driver(firstName, surname);}

    public void setSalary(int salary) {
        checkArgument(salary > 0, "salary cannot be less than one");
        this.salary = salary;
        log.info("a machinist named {} now receives a salary of {}", this.getFirstName(), salary);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("\n\n\nfirstName", firstName)
                .add("\nsurname", surname)
                .add("\nage", age)
                .add("\nsalary", salary)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Driver driver = (Driver) o;
        return salary == driver.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), salary);
    }
}
