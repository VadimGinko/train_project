package com.trains.users;

import com.google.common.base.Objects;
import com.trains.railwayCarriages.Coach;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import static com.google.common.base.Preconditions.checkArgument;

@Slf4j
public final class Passenger extends User {
    @Getter private int passengerSeat;

    public Passenger(String firstName, String surname) {
        super(firstName, surname);
    }

    public static Passenger of(String firstName, String surname){return new Passenger(firstName, surname);}

    //add ticket number
    private void setPassengerSeat(int passengerSeat) {
        checkArgument(passengerSeat > 0, "passengerSeat cannot be less than one");
        this.passengerSeat = passengerSeat;
        log.info("the passenger {} received the seat {}", this.firstName, passengerSeat);
    }

    public int orderTicket(Coach coach){
        int seatNumber = coach.addPassenger(this);
        this.setPassengerSeat(seatNumber);
        return seatNumber;
    }

    public int orderTicket(Coach coach, int seat){
        int seatNumber = coach.addPassenger(this, seat);
        this.setPassengerSeat(seatNumber);
        return seatNumber;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("\n\n\nfirstName", firstName)
                .add("\nsurname", surname)
                .add("\nage", age)
                .add("\npassengerSeat", passengerSeat)
                .toString();
    }
}
