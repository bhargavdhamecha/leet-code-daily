package leetcode;

/**
 * @link https://leetcode.com/problems/find-the-maximum-number-of-fruits-collected/?envType=daily-question&envId=2025-08-07
 */
public class MaxCollectedFruits {
    int maxFruits = 0;
    public static void main(String[] args) {
        MaxCollectedFruits m = new MaxCollectedFruits();
        int[][] fruits = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        System.out.println("Max collected fruits: " + m.maxCollectedFruits(fruits));
    }
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int[][] dp = new int[n][n];

        dp[0][0] = fruits[0][0];

        // Fill first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + fruits[0][j];
        }

        // Fill first column
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + fruits[i][0];
        }

        // Fill rest of the dp table
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + fruits[i][j];
            }
        }

        return dp[n-1][n-1];
    }

    private void calculateMaxFruits(int[][] fruits, int x, int y, int n, int maxFruits) {
        if( x < 0 || x >= n || y < 0 || y >= n) {
            return; // Out of bounds
        }
        maxFruits += fruits[x][y]; // Collect fruits at (x, y)

        if( x==y && x == n-1) {
            calculateMaxFruits(fruits, x+1, y+1, n, maxFruits);
        } else if (x > y && y < n-1) {
            calculateMaxFruits(fruits, x, y+1, n, maxFruits);
        } else if (y < x &&  x < n-1) {
            calculateMaxFruits(fruits, x+1, y, n, maxFruits);
        }
    }
}
