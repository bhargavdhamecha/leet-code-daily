package leetcode;

/**
 * @link https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/description/
 * @Description Category: Medium
 */
public class MaxBitWiseOR {
    public int count = 0;
    public int countMaxOrSubsets(int[] nums) {
        int len = nums.length;
        int maxOR = 0;
        if(len == 1){
            return len;
        }
        else{
            for(int i = 0; i < nums.length; i++){
                maxOR = maxOR | nums[i];
            }

            dfs(nums, 0, 0, maxOR);
            return count;
        }
    }

    private void dfs (int[] nums, int index, int currentOR, int targetOR){
        if (index == nums.length){
            if(currentOR == targetOR){
                count++;
            }
            return;
        }

        // including current number
        dfs(nums, index+1, currentOR | nums[index], targetOR);

        // excluding current number for bitwise OR operation
        dfs(nums, index+1, currentOR , targetOR);

    }

    public static void main(String[] args) {
        MaxBitWiseOR maxBitWiseOR = new MaxBitWiseOR();
        int[] nums = {3,1};
        int result = maxBitWiseOR.countMaxOrSubsets(nums);
        System.out.println("Count of maximum bitwise OR subsets: " + result); // Output: 2
    }
}
