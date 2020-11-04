import com.trains.railwayCarriages.Coach;
import com.trains.users.Passenger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CoachTest {

    @Test
    public void test_constructor_success(){
        Assertions.assertDoesNotThrow(() -> Coach.of(10,20,20));
    }

    @Test
    public void test_constructor_invalid(){
        assertThrows(IllegalArgumentException.class, () ->Coach.of(10,20, -20));
    }

    @Test
    public void test_addPassenger_success() {
        Coach coach = Coach.of(100, 200, 190);
        Passenger passenger = Passenger.of("Vadim", "Ginko");

        int seatNumber = coach.addPassenger(passenger);
        assertEquals(seatNumber, 1);
    }

    @Test
    public void test_addPassenger_invalid() {
        Coach coach = Coach.of(100, 200, 190);

        Passenger passenger2 = null;
        assertThrows(NullPointerException.class, () -> coach.addPassenger(passenger2));

        Coach coach2 = Coach.of(100, 200, 2);
        Passenger passenger3 = Passenger.of("Vadim", "Ginko");
        Passenger passenger4 = Passenger.of("Vadim", "Ginko");
        Passenger passenger5 = Passenger.of("Vadim", "Ginko");
        coach2.addPassenger(passenger3);
        coach2.addPassenger(passenger4);
        assertThrows(IllegalArgumentException.class, () -> coach2.addPassenger(passenger5));
    }

    @Test
    public void test_addPassenger_with_seat_success() {
        Coach coach = Coach.of(100, 200, 190);
        Passenger passenger = Passenger.of("Vadim", "Ginko");

        int seatNumber = coach.addPassenger(passenger, 20);
        assertEquals(seatNumber, 20);
    }

    @Test
    public void test_addPassenger_with_seat_invalid() {
        Coach coach = Coach.of(100, 200, 190);

        Passenger passenger2 = null;
        assertThrows(NullPointerException.class, () -> coach.addPassenger(passenger2, 10));

        Coach coach2 = Coach.of(100, 200, 20);
        Passenger passenger3 = Passenger.of("Vadim", "Ginko");
        Passenger passenger4 = Passenger.of("Vadim", "Ginko");
        coach2.addPassenger(passenger3, 10);
        assertThrows(IllegalArgumentException.class, () -> coach2.addPassenger(passenger4, 10));
    }

    @Test
    public void test_dropPassengers() {
        Coach coach = Coach.of(100, 200, 190);
        Passenger passenger1 = Passenger.of("Vadim", "Ginko");
        Passenger passenger2 = Passenger.of("Vadi2", "Ginko");
        Passenger passenger3 = Passenger.of("Vadi3", "Ginko");
        Passenger passenger4 = Passenger.of("Vadi4", "Ginko");
        Passenger passenger5 = Passenger.of("Vadi5", "Ginko");

        coach.addPassenger(passenger1);
        coach.addPassenger(passenger2);
        coach.addPassenger(passenger3);
        coach.addPassenger(passenger4);
        coach.addPassenger(passenger5);

        coach.dropPassengers();
        assertEquals(coach.getFreeSeats().size(), 190);
    }
}