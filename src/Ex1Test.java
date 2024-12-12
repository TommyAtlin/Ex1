import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
        assertTrue(Ex1.equals(s10, s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for (int i = 0; i < good.length; i++) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }

        String[] not_good = {"b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for (int i = 0; i < not_good.length; i++) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }
    @Test
    void number2IntAdditionalTests() {
        // Valid inputs for base 3 to 16
        assertEquals(20, Ex1.number2Int("202b3"));  // Base-3 "202b3" = 20 in decimal
        assertEquals(500, Ex1.number2Int("1F4bG")); // Hexadecimal "1F4b16" = 500
        assertEquals(121, Ex1.number2Int("321b6"));  // Base-6 "321b6" = 102 in decimal

        // Invalid base and format cases
        assertEquals(-1, Ex1.number2Int("120b1"));  // Invalid base 1
        assertEquals(-1, Ex1.number2Int("ABbI"));   // Invalid base I (out of range)
        assertEquals(-1, Ex1.number2Int("abc123b10")); // Invalid characters
    }

    // Additional test case for `isNumber` method
    @Test
    void isNumberAdditionalTests() {
        assertTrue(Ex1.isNumber("202b3"));  // Valid base-3 number
        assertTrue(Ex1.isNumber("AbC"));  // Valid base-12 number

        assertFalse(Ex1.isNumber("202b1"));  // Invalid base (should be at least 2)
        assertFalse(Ex1.isNumber("78bH"));   // Invalid base (should be <= G)
        assertFalse(Ex1.isNumber("1abc"));   // Missing base indicator 'b'
    }

    // Test for equality of two base-b numbers
    @Test
    void equalsTest() {
        assertTrue(Ex1.equals("1101b2", "13bA")); // Binary 1101 (13 in decimal) = Decimal 13
        assertFalse(Ex1.equals("1011b2", "1000b2")); // Binary 1011 != Binary 1000
    }

    // Test edge case for zero and negative values
    @Test
    void edgeCasesTest() {
        assertEquals(0, Ex1.number2Int("0b3"));   // Zero in base 3
        assertEquals(0, Ex1.number2Int("0b4"));  // Zero in base 4
        assertEquals(0, Ex1.number2Int("0b6"));  // Zero in base 6
        assertEquals(-1, Ex1.number2Int("-1b10")); // Invalid number format
    }
}