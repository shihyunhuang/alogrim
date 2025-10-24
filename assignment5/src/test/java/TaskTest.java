import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class TaskTest {
    Task t = new Task();

    @Test
    void testTask1(){
        assertTrue(t.contain("ab", "eidbaooo"));        // Sample case
        assertFalse(t.contain("ab", "eidboaoo"));       // Sample test
        assertFalse(t.contain("abefkab", "abc"));       // s1 is longer than s2
        assertTrue(t.contain("aoobod", "eidbaooo"));
    }

    @Test
    void testTask(){
        assertEquals(7, t.countSteps(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        assertEquals(7, t.countSteps(new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
        assertEquals(0, t.countSteps(new int[]{1, 5, 8, 6, 3, 7, 2, 4}));
        assertEquals(1, t.countSteps(new int[]{1, 5, 8, 5, 3, 7, 2, 4}));
    }
}
