package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * uses set - Iterative approach (Dynamic Programming with Set Propagation)
 * it will iterate through the array and calculate current and previous bitwise ORs
 * rather than calculating all the previous all elems.
 *
 *
 *
 * extra info:
 *
 * | Name / Term              | Explanation                                                                                            |
 * | ------------------------ | ------------------------------------------------------------------------------------------------------ |
 * | **DP with Sets**         | Using sets to store DP states                                                                          |
 * | **Set-based DP**         | Same as above — avoids redundancy                                                                      |
 * | **State Compression DP** | Avoids storing all previous states explicitly                                                          |
 * | **Sliding Window DP**    | Though not literal sliding windows, it processes each step incrementally using previous window results |
 * | **Bitmask/Bitwise DP**   | Applies when bitwise operations are central                                                            |
 * | **Prefix OR DP**         | Because it builds results from prefixes ending at `i`                                                  |
 */
public class SubarrayBitwiseORsOptimal {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4};
        SubarrayBitwiseORs subarrayBitwiseORs = new SubarrayBitwiseORs();
        int output = subarrayBitwiseORs.subarrayBitwiseORs(nums);
        System.out.println("Count of subarray bitwise ORs: " + output); // Output: 6
    }

    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Set<String> visited = new HashSet<>();  // memoization to avoid recomputation

        for (int i = 0; i < arr.length; i++) {
            dfs(arr, i, 0, result, visited);
        }

        System.out.println("Set of unique bitwise ORs: " + result);
        return result.size();
    }

    public void dfs(int[] arr, int index, int currentOR, Set<Integer> result, Set<String> visited) {
        if (index >= arr.length) return;

        currentOR |= arr[index];

        String key = index + "_" + currentOR;
        if (visited.contains(key)) return; // skip duplicate computation
        visited.add(key);

        result.add(currentOR);
        dfs(arr, index + 1, currentOR, result, visited); // continue with next index
    }
}

