package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @link: https://leetcode.com/problems/ways-to-express-an-integer-as-sum-of-powers/
 * Given an integer n, find the number of ways to express it as a sum of powers of 2.
 */
public class NumberOfWays {

    public static void main(String[] args) {
        NumberOfWays n = new NumberOfWays();
        int nValue = 10;
        int x = 2; // Power of 2
        int result = n.numberOfWays(nValue, x);
        System.out.println("Number of ways to express " + nValue + " as a sum of powers of " + x + " is: " + result);
    }

    public int numberOfWays(int n, int x) {
        if (n < 0 || x <= 0) {
            return 0; // Invalid input
        }

        List<Integer> powers = new ArrayList<>();
        int base = 1; // Start with the first power of x
        while (Math.pow(base, x) <= n) {
            powers.add((int) Math.pow(base, x));
            base++;
        }

        int m = powers.size();
        int[][] dp = new int[m + 1][n+1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = m-1; i >= 0; i--) {
            for (int sum = 0; sum <= n; sum++) {
                dp[i][sum] += dp[i+1][sum]; // Exclude current power
                if (sum >= powers.get(i)) {
                    dp[i][sum] += dp[i+1][sum - powers.get(i)]; // Include current power
                }
            }
        }
        return dp[0][n];
    }


}
