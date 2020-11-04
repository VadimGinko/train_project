package com.trains.railwayCarriages;

import com.google.common.base.Objects;
import com.trains.users.Driver;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import static com.google.common.base.Preconditions.checkNotNull;

@Slf4j
public final class Locomotive extends RailwayCarriage {
    private Driver driver;

    public Locomotive(int weight, int length) {
        super(weight, length);
    }

    public static Locomotive of(int weight, int length){return new Locomotive(weight, length);}

    public void setDriver(Driver driver) {
        checkNotNull(driver);
        this.driver = driver;
        log.info("the driver {} was assigned to the locomotive{}", driver.getFirstName(), this.id);
    }

    public Driver getDriver() {
        Driver newDriver = new Driver(driver.getFirstName(), driver.getSurname());
        newDriver.setSalary(this.driver.getSalary());
        return newDriver;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("\n\n\ndriver", driver)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locomotive that = (Locomotive) o;
        return Objects.equal(driver, that.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(driver);
    }
}
