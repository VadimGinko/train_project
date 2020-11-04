import com.trains.railwayCarriages.Coach;
import com.trains.users.Passenger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PassengerTest {

    @Test
    public void test_orderTicket() {
        Coach coach = Coach.of(100, 200, 190);
        Passenger passenger = Passenger.of("Vadim", "Ginko");
        Passenger passenger2 = Passenger.of("neVadim", "Ginko");
        assertEquals(passenger.orderTicket(coach), 1);
        assertEquals(passenger2.orderTicket(coach), 2);
        assertEquals(passenger.orderTicket(coach), passenger.getPassengerSeat());
        assertEquals(passenger2.orderTicket(coach), passenger2.getPassengerSeat());
    }

    @Test
    public void test_orderTicketWithSeatNumber() {
        Coach coach = Coach.of(100, 200, 190);
        Passenger passenger = Passenger.of("Vadim", "Ginko");
        Passenger passenger2 = Passenger.of("neVadim", "Ginko");
        assertEquals(passenger.orderTicket(coach, 10), 10);
        assertEquals(passenger2.orderTicket(coach, 20), 20);
        assertEquals(passenger.orderTicket(coach, 30), passenger.getPassengerSeat());
        assertEquals(passenger2.orderTicket(coach, 40), passenger2.getPassengerSeat());
    }
}