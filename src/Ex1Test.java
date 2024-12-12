import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Ex1Test {

    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(11, v);

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
        for (String s : good) {
            assertTrue(Ex1.isNumber(s));
        }

        String[] not_good = {"b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for (String s : not_good) {
            assertFalse(Ex1.isNumber(s));
        }
    }

    @Test
    void number2IntAdditionalTests() {
        // Valid inputs for base 3 to 16
        assertEquals(20, Ex1.number2Int("202b3"));
        assertEquals(500, Ex1.number2Int("1F4bG"));
        assertEquals(121, Ex1.number2Int("321b6"));

        // Invalid base and format cases
        assertEquals(-1, Ex1.number2Int("120b1"));
        assertEquals(-1, Ex1.number2Int("ABbI"));
        assertEquals(-1, Ex1.number2Int("abc123b10"));
    }

    @Test
    void isNumberAdditionalTests() {
        assertTrue(Ex1.isNumber("202b3"));
        assertTrue(Ex1.isNumber("D5bB"));

        assertFalse(Ex1.isNumber("202b1"));
        assertFalse(Ex1.isNumber("78bH"));
        assertFalse(Ex1.isNumber("1abc"));
    }

    @Test
    void equalsTest() {
        assertTrue(Ex1.equals("1101b2", "13bA"));
        assertFalse(Ex1.equals("1011b2", "1000b2"));
    }

    @Test
    void edgeCasesTest() {
        assertEquals(0, Ex1.number2Int("0b3"));
        assertEquals(0, Ex1.number2Int("0b4"));
        assertEquals(0, Ex1.number2Int("0b6"));
        assertEquals(-1, Ex1.number2Int("-1b10"));
    }

    @Test
    void int2NumberTest() {
        assertEquals("1101b2", Ex1.int2Number(13, 2));
        assertEquals("1F4b16", Ex1.int2Number(500, 16));
        assertEquals("202b3", Ex1.int2Number(20, 3));
    }

    @Test
    void maxIndexTest() {
        String[] numbers = {"101b2", "A5b16", "15b10"};
        assertEquals(1, Ex1.maxIndex(numbers)); //

        String[] numbersWithInvalid = {"101b2", "invalid", "15b10"};
        assertEquals(0, Ex1.maxIndex(numbersWithInvalid));

        String[] emptyArray = {};
        assertEquals(-1, Ex1.maxIndex(emptyArray));
    }

    @Test
    void invalidInputTests() {
        assertThrows(IllegalArgumentException.class, () -> Ex1.int2Number(10, 17));
        assertThrows(IllegalArgumentException.class, () -> Ex1.int2Number(-10, 10));
    }
}
