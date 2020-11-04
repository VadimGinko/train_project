package com.trains.railwayCarriages;

import com.google.common.base.Objects;
import com.trains.users.Passenger;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.ArrayList;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@Slf4j
public final class Coach extends RailwayCarriage {
    private final int numberOfSeats;
    private List<Passenger> passengers = new ArrayList<>();
    private List<Integer> freeSeats = new ArrayList<>();


    public Coach(int weight, int length, int numberOfSeats) {
        super(weight, length);
        checkArgument(numberOfSeats > 0, "numberOfSeats cannot be less than one");
        this.numberOfSeats = numberOfSeats;
        this.generateFreeSeatsList();
    }

    public static Coach of(int weight, int length, int numberOfSeats){return new Coach(weight, length, numberOfSeats);}

    private void generateFreeSeatsList(){
        for (var i = 1;i <= this.numberOfSeats; i++)
            this.freeSeats.add(i);
        log.info("a list containing the numbers of available seats is generated");
    }

    //if the passenger has not chosen a seat, he is given the first free seat
    public int addPassenger(Passenger passenger) {
        checkNotNull(passenger);
        checkArgument(this.isRailwayCarriageFull(), "full railway carriage");
        this.passengers.add(passenger);
        int seat = this.freeSeats.remove(0);
        log.info("a passenger named {} has booked a seat with number {}", passenger.getFirstName(), seat);
        return seat;
    }

    public int addPassenger(Passenger passenger, int seat) {
        checkNotNull(passenger);
        checkArgument(this.isThisSeatFree(seat), "this seat is taken or no such seat");
        checkArgument(this.isRailwayCarriageFull(), "full railway carriage");
        this.passengers.add(passenger);
        this.freeSeats.remove(Integer.valueOf(seat));
        log.info("a passenger named {} has booked a seat with number {}", passenger.getFirstName(), seat);
        return seat;
    }

    //when the trip is over
    public void dropPassengers() {
        passengers = new ArrayList<>();
        freeSeats = new ArrayList<>();
        this.generateFreeSeatsList();
    }

    public List<Integer> getFreeSeats() {
        return new ArrayList<Integer>(freeSeats);
    }

    private boolean isThisSeatFree(int seat){
        return this.freeSeats.contains(seat);
    }

    private boolean isRailwayCarriageFull(){
        return !this.freeSeats.isEmpty();
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("\n\n\nnumberOfSeats", numberOfSeats)
                .add("\npassengers", passengers)
                .add("\nfreeSeats", freeSeats)
                .add("\nid", id)
                .add("\nweight", weight)
                .add("\nlength", length)
                .add("\nnextRailwayCarriage", nextRailwayCarriage)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Coach coach = (Coach) o;
        return numberOfSeats == coach.numberOfSeats &&
                Objects.equal(passengers, coach.passengers) &&
                Objects.equal(freeSeats, coach.freeSeats);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), numberOfSeats, passengers, freeSeats);
    }
}
