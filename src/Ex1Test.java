import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ex1Test {

    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v, 11);

        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v, 2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v, v2);

        assertTrue(Ex1.equals(s10, s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for (int i = 0; i < good.length; i++) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }

        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for (int i = 0; i < not_good.length; i++) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }

    @Test
    void int2NumberTest() {
        // Valid conversions
        assertEquals("11", Ex1.int2Number(11, 2));
        assertEquals("A", Ex1.int2Number(10, 16));
        assertEquals("1011", Ex1.int2Number(11, 2));

        // Invalid base
        assertEquals("", Ex1.int2Number(11, 1)); // Base < 2
        assertEquals("", Ex1.int2Number(11, 17)); // Base > 16
    }

    @Test
    void maxIndexTest() {
        String[] arr = {"1011b2", "1011bA", "1001b2"};
        int maxIndex = Ex1.maxIndex(arr);
        assertEquals(1, maxIndex); // "1011bA" should be the largest number
    }
}
