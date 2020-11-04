import com.trains.railwayCarriages.Locomotive;
import com.trains.users.Driver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LocomotiveTest {
    @Test
    public void test_setDriver_success() {
        Locomotive locomotive = Locomotive.of(10, 10);
        Driver driver = Driver.of("Vadim", "Ginko");
        assertDoesNotThrow(() -> locomotive.setDriver(driver));
    }

    @Test
    public void test_setDriver_invalid() {
        Locomotive locomotive = Locomotive.of(10, 10);
        Driver driver = null;
        assertThrows(NullPointerException.class, () ->locomotive.setDriver(driver));
    }


    @Test
    public void test_getDriver() {
        Locomotive locomotive = Locomotive.of(10, 10);
        Driver driver = Driver.of("Vadim", "Ginko");
        driver.setSalary(200);

        locomotive.setDriver(driver);

        assertEquals(driver, locomotive.getDriver());
    }
}