public class BitOperations {
    public static boolean getBit(int x, int i) {
        return ((x & (1 << i)) != 0);
    }

    public static int setBit(int x, int i) {
        return x | (1 << i);
    }

    // set i-th bit to zero
    public static int clearBit(int x, int i) {
        int mask = ~(1 << i);
        return x & mask;
    }


}
