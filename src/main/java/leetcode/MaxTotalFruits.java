package leetcode;

import java.util.HashMap;

/**
 * maximum-fruits-harvested-after-at-most-k-steps
 * need to find maximum collectable fruits within k steps in either direction left or right.
 *
 */
public class MaxTotalFruits {
    public static void main(String[] args) {
        MaxTotalFruits m = new MaxTotalFruits();
//        int[][] fruits = {{2,8},{6,3},{8,6}};
        int[][] fruits = {{0,9}, {4,1}, {5,7}, {6,2}, {7,4}, {10,9}};
        System.out.println("Result: "+ m.maxTotalFruits(fruits, 5, 4));
    }

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int max = 0;
        int sum = 0;

        int left = 0;
        for (int right = 0; right < n; right++) {
            sum += fruits[right][1];

            // Shrink the window from the left if the cost exceeds k
            while (left <= right && steps(fruits, startPos, left, right) > k) {
                sum -= fruits[left][1];
                left++;
            }

            max = Math.max(max, sum);
        }

        return max;
    }

    private int steps(int[][] fruits, int startPos, int left, int right) {
        int leftPos = fruits[left][0];
        int rightPos = fruits[right][0];
        return (rightPos - leftPos) + Math.min(Math.abs(startPos - leftPos), Math.abs(startPos - rightPos));
    }

}
