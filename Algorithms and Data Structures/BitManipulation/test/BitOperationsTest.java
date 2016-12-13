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

    @Test
    void testClearBit0() {
        int x = 20;
        assertEquals(20, BitOperations.clearBit(x, 0));
        assertEquals(20, BitOperations.clearBit(x, 1));
        assertEquals(16, BitOperations.clearBit(x, 2));
        assertEquals(20, BitOperations.clearBit(x, 3));
        assertEquals(4, BitOperations.clearBit(x, 4));
        assertEquals(20, BitOperations.clearBit(x, 5)); // extra zero attached on the left, nothing changes
    }

    @Test
    void testClearBit1() {
        int x = 100;
        assertEquals(100, BitOperations.clearBit(x, 0));
        assertEquals(100, BitOperations.clearBit(x, 1));
        assertEquals(96, BitOperations.clearBit(x, 2));
        assertEquals(100, BitOperations.clearBit(x, 3));
        assertEquals(100, BitOperations.clearBit(x, 4));
        assertEquals(68, BitOperations.clearBit(x, 5));
        assertEquals(36, BitOperations.clearBit(x, 6));
    }

    @Test
    void testRightShift1() {
        int x = 89; // 1011001
        assertEquals(44, BitOperations.rightShift(x, 1)); // 101100
        assertEquals(22, BitOperations.rightShift(x, 2)); // 10110
        assertEquals(11, BitOperations.rightShift(x, 3)); // 1011
        assertEquals(5, BitOperations.rightShift(x, 4)); // 101
        assertEquals(2, BitOperations.rightShift(x, 5)); // 10
        assertEquals(1, BitOperations.rightShift(x, 6)); // 1
    }

    @Test
    void testIntToBit0() {
        assertEquals("111", BitOperations.intToBit(7));
        assertEquals("10000000000", BitOperations.intToBit(1024));
        assertEquals("1", BitOperations.intToBit(1));
    }

    @Test
    void testClearBitThoughI0() {
        int x = 89; // 1011001
        int i = 4;
        int cleared = BitOperations.clearBitThoughI(x, i);
        assertEquals("1001", BitOperations.intToBit(cleared));
    }

    @Test
    void testClearBitThoughI1() {
        int x = 1533; // 10111111101
        int i = 7;
        int cleared = BitOperations.clearBitThoughI(x, i);
        assertEquals("1111101", BitOperations.intToBit(cleared));
    }

    @Test
    void testClearBitThoughI2() {
        int x = 287; // 100011111
        int i = 1;
        int cleared = BitOperations.clearBitThoughI(x, i);
        assertEquals("1", BitOperations.intToBit(cleared));
    }

    @Test
    void testClearBitThoughI3() {
        int x = 287; // 100011111
        int i = 5;
        int cleared = BitOperations.clearBitThoughI(x, i);
        assertEquals("11111", BitOperations.intToBit(cleared));
    }
}
