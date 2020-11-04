import com.trains.Cargo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

public class CargoTest {
    @Test
    public void test_setWeight_invalid() {
        Cargo cargo = Cargo.of("bad");
        assertThrows(IllegalArgumentException.class, () -> cargo.setWeight(-5));
    }

    @Test
    public void test_setWeight_success() {
        Cargo cargo = Cargo.of("bad");
        assertDoesNotThrow(() -> cargo.setWeight(20));
    }

    @Test
    public void test_setVolume_invalid() {
        Cargo cargo = Cargo.of("bad");
        assertThrows(IllegalArgumentException.class, () -> cargo.setVolume(-5));
    }

    @Test
    public void test_setVolume_success() {
        Cargo cargo = Cargo.of("bad");
        assertDoesNotThrow(() -> cargo.setVolume(20));
    }
}