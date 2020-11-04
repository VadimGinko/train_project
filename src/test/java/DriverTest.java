import com.trains.users.Driver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DriverTest {
    @Test
    public void test_setAge_invalid() {
        Driver driver = Driver.of("Vadim", "Ginko");
        assertThrows(IllegalArgumentException.class, () -> driver.setSalary(-5));
    }

    @Test
    public void test_setAge_success() {
        Driver driver = Driver.of("Vadim", "Ginko");
        assertDoesNotThrow(() -> driver.setSalary(20));
    }
}