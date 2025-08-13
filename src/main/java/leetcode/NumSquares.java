package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @link: https://leetcode.com/problems/perfect-squares/
 * Given a positive integer n, find the least number of perfect square numbers that sum to n
 */
public class NumSquares {
    public static void main(String[] args) {
        NumSquares clasz = new NumSquares();
        int n = 13;
        System.out.println("perfect square of "+n+" need num: "+ clasz.numSquares(n));
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];  // dp[i] = least number of perfect squares to sum to i
        Arrays.fill(dp, Integer.MAX_VALUE);  // Init with max
        dp[0] = 0;

        // Precompute all perfect squares <= n
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }

        // build dp array
        for (int i = 0; i <= n ; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;  // Skip if no perfect square sum found for i
            for (int square : squares) {
                if (i + square > n) break;  // No need to check further if i + square exceeds n
                dp[i + square] = Math.min(dp[i + square], dp[i] + 1);
            }// Ensure we can reach i from i-1
        }
        return dp[n];
    }
}
