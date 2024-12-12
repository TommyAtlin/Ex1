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
    void int2NumberTests() { // Tests for int2Number Method
        assertEquals("20bA", Ex1.int2Number(20, 10));  //
        assertEquals("500bA", Ex1.int2Number(500, 10)); //
        assertEquals("121bA", Ex1.int2Number(121, 10)); //
        assertEquals("0b2", Ex1.int2Number(0, 2));
        assertEquals("FbG", Ex1.int2Number(15, 16));
        assertEquals("FFbG", Ex1.int2Number(255, 16));
        assertEquals("7b8", Ex1.int2Number(7, 8));
        assertEquals("10b2", Ex1.int2Number(2, 2));
    }

    @Test
    void int2Number() { //Tests for number2Int Method
        assertEquals(20, Ex1.number2Int("202b3"));
        assertEquals(500, Ex1.number2Int("1F4bG"));
        assertEquals(121, Ex1.number2Int("321b6"));
        assertEquals(-1, Ex1.number2Int("120b1"));
        assertEquals(-1, Ex1.number2Int("ABbI"));
        assertEquals(-1, Ex1.number2Int("abc123b10"));
        assertEquals(0, Ex1.number2Int("0bA"));
        assertEquals(-1, Ex1.number2Int("123b0"));
        assertEquals(123, Ex1.number2Int("123"));
    }

    @Test
    void isNumberTest() { // Tests for isNumber method
        assertTrue(Ex1.isNumber("202b3"));
        assertTrue(Ex1.isNumber("AbC"));
        assertFalse(Ex1.isNumber("202b1"));
        assertFalse(Ex1.isNumber("78bH"));
        assertFalse(Ex1.isNumber("1abc"));
        assertFalse(Ex1.isNumber(""));
        assertFalse(Ex1.isNumber("   "));
        assertFalse(Ex1.isNumber("123bx"));
    }

    @Test
    void equalsTest() { // Tests  for equals method
        assertTrue(Ex1.equals("1101b2", "13bA"));
        assertFalse(Ex1.equals("1011b2", "1000b2"));
        assertTrue(Ex1.equals("6bA", "110b2"));
        assertFalse(Ex1.equals("", "123bA"));
        assertFalse(Ex1.equals("12bB", "1515bT"));
    }

    @Test
    void negetiveCasesTest() { // Test negative representation of numbers
        assertEquals(-1, Ex1.number2Int("-1b10"));
    }
    @Test
    void zeroBaseTest() {  // Test zero base invalid format
        assertEquals(-1, Ex1.number2Int("0010b0"));
        assertEquals(-1, Ex1.number2Int("123b0"));
        assertEquals(-1, Ex1.number2Int("AGDb0"));
    }

    @Test
    void zeroLeadTest() { // Test for number of zeros at the start
        assertEquals(7, Ex1.number2Int("0012b5"));
        assertEquals(0, Ex1.number2Int("000b2"));
        assertEquals(23, Ex1.number2Int("000023bA"));
    }
    @Test
    void manyBases() { // Test for invalid representation of base (number wise)
        assertEquals(-1, Ex1.number2Int("123bb2"));
        assertEquals(-1, Ex1.number2Int("AGFbbb3"));
        assertEquals(-1, Ex1.number2Int("01bbbb5"));
    }
}