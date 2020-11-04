import com.trains.users.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class UserTest {
    @Test
    public void test_setAge_invalid() {
        User user = User.of("Vadim", "Ginko");
        assertThrows(IllegalArgumentException.class, () -> user.setAge(-5));
    }

    @Test
    public void test_setAge_success() {
        User user = User.of("Vadim", "Ginko");
        assertDoesNotThrow(() -> user.setAge(20));
    }
}