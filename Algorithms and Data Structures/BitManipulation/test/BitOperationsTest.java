import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitOperationsTest {
    @Test
    void testGetBit1() {
        int x = 20; // 16 + 4 = 10100
        assertEquals(true, BitOperations.getBit(x, 2));
        assertEquals(true, BitOperations.getBit(x, 4));
        assertEquals(false, BitOperations.getBit(x, 0));
        assertEquals(false, BitOperations.getBit(x, 1));
    }

    @Test
    void testGetBit2() {
        int x = 100; // 64 + 32 + 4 = 1100100
        assertEquals(false, BitOperations.getBit(x, 0));
        assertEquals(false, BitOperations.getBit(x, 1));
        assertEquals(true, BitOperations.getBit(x, 2));
        assertEquals(false, BitOperations.getBit(x, 3));
        assertEquals(false, BitOperations.getBit(x, 4));
        assertEquals(true, BitOperations.getBit(x, 5));
        assertEquals(true, BitOperations.getBit(x, 6));
    }

    @Test
    void testSetBit1() {
        int x = 20; // 16 + 4 = 10100
        assertEquals(21, BitOperations.setBit(x, 0));
        assertEquals(22, BitOperations.setBit(x, 1));
        assertEquals(20, BitOperations.setBit(x, 2));
        assertEquals(28, BitOperations.setBit(x, 3));
        assertEquals(20, BitOperations.setBit(x, 4));
        assertEquals(52, BitOperations.setBit(x, 5));
    }
}
