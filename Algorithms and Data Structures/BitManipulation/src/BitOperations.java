public class BitOperations {

    // true if i-th bit is one, false is zero
    public static boolean getBit(int x, int i) {
        return ((x & (1 << i)) != 0);
    }

    // set i-th bit to one
    public static int setBit(int x, int i) {
        return x | (1 << i); // create 00010000 kind of bit mask to set specific bit
    }

    // set i-th bit to zero
    public static int clearBit(int x, int i) {
        int mask = ~(1 << i); // creates 111101111 kind of bit mask to clear i-th bit
        return x & mask;
    }


}
