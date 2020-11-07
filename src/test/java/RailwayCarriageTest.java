import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.trains.railwayCarriages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class RailwayCarriageTest {

    @Test
    public void test_constructor_success(){
        Assertions.assertDoesNotThrow(() -> RailwayCarriage.of(10,20));
    }

    @Test
    public void test_constructor_invalid_by_weight(){
        assertThrows(IllegalArgumentException.class, () ->
                RailwayCarriage.of(-10,20));
    }

    @Test
    public void test_constructor_invalid_by_length(){
        assertThrows(IllegalArgumentException.class, () ->
                RailwayCarriage.of(10,-20));
    }

    @Test
    public void test_attachRailwayCarriage_success() {
        Locomotive locomotive = Locomotive.of(5, 15);
        FreihtCar freihtCar = FreihtCar.of(10, 20, 30);
        Coach coach = Coach.of(15, 25, 35);

        assertDoesNotThrow(() -> locomotive.attachRailwayCarriage(freihtCar));
        assertDoesNotThrow(() -> freihtCar.attachRailwayCarriage(coach));
    }

    @Test
    public void test_attachRailwayCarriage_invalid() {
        Locomotive locomotive = Locomotive.of(5, 15);
        FreihtCar freihtCar = FreihtCar.of(10, 20, 30);

        //the locomotive must not be hooked, since it is always the first carriage
        assertThrows(LocomotiveException.class, () -> freihtCar.attachRailwayCarriage(locomotive));
    }

}