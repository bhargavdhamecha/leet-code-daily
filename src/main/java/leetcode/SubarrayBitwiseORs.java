package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * subarrayBitwiseORs
 */
public class SubarrayBitwiseORs {

    public static void main(String[] args) {
        int[] nums = {1,2,4};
        SubarrayBitwiseORs subarrayBitwiseORs = new SubarrayBitwiseORs();
        int output = subarrayBitwiseORs.subarrayBitwiseORs(nums);
        System.out.println("Count of subarray bitwise ORs: " + output); // Output: 3
    }
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> ls = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int n = arr.length;
        if(n == 0 || n ==1) {
            return n;
        }
        for (int i = 0; i < n; i++) {
            dfs(arr, i, 0, ls, visited);
        }
        System.out.println("Set of unique bitwise ORs: " + ls);
        return ls.size();
    }

    public void dfs(int[] arr, int index, int currentOR, Set<Integer> ls, Set<String> visited) {
        if (index == arr.length) {
            return;
        }

        currentOR |= arr[index];
        String key = index + "_" + currentOR;
        if (visited.contains(key)) return; // skip duplicate computation
        visited.add(key);
        ls.add(currentOR);
        // excluding current number
        dfs(arr, index + 1, currentOR, ls,visited);
    }
}
