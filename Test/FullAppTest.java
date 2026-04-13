import org.junit.Test;
import static org.junit.Assert.*;

public class FullAppTest {
    Registration reg = new Registration();

    @Test
    public void testValidUsername() {
        assertTrue(reg.checkuserName("jax_"));
    }

    @Test
    public void testValidPassword() {
        // Now requires an actual special character like '!'
        assertTrue(reg.checkPassword("Passw0rd!"));
    }

    @Test
    public void testInvalidPasswordNoSpecial() {
        // This will now correctly return false
        assertFalse(reg.checkPassword("Password123"));
    }

    @Test
    public void testPhoneNumber() {
        assertTrue(reg.checkphoneNumber("0123456789"));
        assertTrue(reg.checkphoneNumber("+27123456789"));
    }

    @Test
    public void testLoginLogic() {
        Login login = new Login("user_", "Pass123!", "Rocky", "Smith");
        assertEquals("Welcome, Rocky Smith! It is great to see you again.",
                login.LoginUser("user_", "Pass123!"));
    }
}