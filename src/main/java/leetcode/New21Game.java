package leetcode;


/**
 * @link: https://leetcode.com/problems/new-21-game/submissions/1738841243/?envType=daily-question&envId=2025-08-17
 *
 * @TODO: SOLVE Again by yourself.
 */
public class New21Game {
    public static void main(String[] args) {
        New21Game n = new New21Game();
        System.out.println("res: " + n.new21Game(21, 17, 10));
    }

    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k - 1 + maxPts) {
            return 1.0;
        }

        double[] dp = new double[n + 1];
        dp[0] = 1.0;

        double windowSum = 1.0; // sum of dp[i - 1] to dp[i - maxPts]
        double result = 0.0;

        for (int i = 1; i <= n; i++) {
            dp[i] = windowSum / maxPts;

            if (i < k) {
                windowSum += dp[i];
            } else {
                result += dp[i];
            }

            if (i - maxPts >= 0) {
                windowSum -= dp[i - maxPts];
            }
        }
        return result;
    }
}
