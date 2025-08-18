package leetcode;

public class IsPowerOfFour {
    public static void main(String[] args) {
        IsPowerOfFour f = new IsPowerOfFour();
        System.out.println("sdf: "+ 0xAAAAAAAA);
        System.out.println("is power of 4: "+ f.isPowerOfFour(-2147483648));
    }

    public boolean isPowerOfFour(int n) {
        if(n != 0 && n % 4 == 0 || n == 1){
            return (n & n-1) == 0 && (n & 0xAAAAAAAA) == 0;
        }
        return false;
    }

    /**
     * note:
     * Correct Bit Position:
     * The single set bit in the binary representation of n must be in an even position
     * (when counting from the right, starting from 0). This distinguishes powers of 4 from other
     * powers of 2 (e.g., 2, 8, 32). A common way to check this is to use a bitmask like 0xAAAAAAAA.
     * This mask has alternating 1s and 0s, with 1s at all odd positions (0-indexed).
     * If n is a power of 4, its single set bit will be at an even position, and therefore,
     * (n & 0xAAAAAAAA) should be 0.
     */
}
