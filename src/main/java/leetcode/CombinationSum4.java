package leetcode;

public class CombinationSum4 {
    public static void main(String[] args) {
        CombinationSum4 cs = new CombinationSum4();
        int[] nums = {1, 2, 3};
        int target = 4;
        int result = cs.combinationSum4(nums, target);
        System.out.println("Number of combinations to reach target " + target + " is: " + result);
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; // Base case: one way to make target
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i-num];
                }
            }
        }

        return dp[target];
    }
}
