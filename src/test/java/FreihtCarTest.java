import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.trains.Cargo;
import com.trains.railwayCarriages.FreihtCar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FreihtCarTest {

    @Test
    public void test_constructor_success(){
        Assertions.assertDoesNotThrow(() -> FreihtCar.of(10,20, 20));
    }

    @Test
    public void test_constructor_invalid_by_maxCapacity(){
        assertThrows(IllegalArgumentException.class, () ->
                FreihtCar.of(10,20, -10));
    }

    @Test
    public void test_addCargo_invalid() {
        FreihtCar freihtCar = FreihtCar.of(300, 400, 5000);

        Cargo cargoNull = null;
        assertThrows(NullPointerException.class, () -> freihtCar.addCargo(cargoNull));

        Cargo cargo = Cargo.of("bad");
        cargo.setWeight(2000);
        cargo.setVolume(300000000);
        assertThrows(IllegalStateException.class, () -> freihtCar.addCargo(cargo));
    }

    @Test
    public void test_addCargo_success() {
        FreihtCar freihtCar = FreihtCar.of(300, 400, 5000);

        Cargo cargo = Cargo.of("bad");
        cargo.setWeight(200);
        cargo.setVolume(200);

        Cargo cargo2 = Cargo.of("chair");
        cargo2.setWeight(300);
        cargo2.setVolume(300);

        Cargo cargo3 = Cargo.of("table");
        cargo3.setWeight(400);
        cargo3.setVolume(400);

        freihtCar.addCargo(cargo);
        freihtCar.addCargo(cargo2);
        freihtCar.addCargo(cargo3);

        assertEquals(freihtCar.getCurrentOccupiedVolume(), 900);
    }

    @Test
    public void test_takeCargos() {
        FreihtCar freihtCar = FreihtCar.of(300, 400, 5000);

        Cargo cargo = Cargo.of("bad");
        cargo.setWeight(200);
        cargo.setVolume(200);

        Cargo cargo2 = Cargo.of("chair");
        cargo2.setWeight(300);
        cargo2.setVolume(300);

        Cargo cargo3 = Cargo.of("table");
        cargo3.setWeight(400);
        cargo3.setVolume(400);

        freihtCar.addCargo(cargo);
        freihtCar.addCargo(cargo2);
        freihtCar.addCargo(cargo3);

        var cargos = freihtCar.takeCargos();
        assertEquals(cargos, ImmutableList.of(cargo, cargo2, cargo3));
        assertEquals(freihtCar.getCurrentOccupiedVolume(), 0);
        assertEquals(freihtCar.getCargos(), new ArrayList<>());
    }
}