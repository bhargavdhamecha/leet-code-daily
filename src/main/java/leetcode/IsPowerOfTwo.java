package leetcode;

public class IsPowerOfTwo {
    public static void main(String[] args) {
        IsPowerOfTwo solution = new IsPowerOfTwo();
        System.out.println(solution.isPowerOfThree(6));  // true
    }

    public boolean isPowerOfTwo(int n) {
       if(n <= 0) {
            return false; // Negative numbers and zero are not powers of two
        }
        return (n-1 & (n - 2)) == 0; // A power of two has only one bit set in its binary representation
    }

    public boolean isPowerOfThree(int n){
        if(n <= 0) {
            return false; // Negative numbers and zero are not powers of three
        }
        while(n % 3 == 0) {
            n /= 3;
        }
        return n == 1; // If n is reduced to 1, it is a power of three
    }
}
