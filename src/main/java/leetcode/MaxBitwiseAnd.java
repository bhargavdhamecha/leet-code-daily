package leetcode;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * Longest Subarray with Maximum Bitwise AND
 * logic: to find the max bitwise AND, need to find max elements from the array
 * in-short need to find the max elements from the array cnd count it.
 */
public class MaxBitwiseAnd {

    public static void main(String[] args) {
        int[] nums = {311155,311155,311155,311155,311155,311155,311155,311155,201191,311155};

        /* implementation logic:
            1. find the max from the array
            2. count its occurrence

            how to find its occurrence?
            without iterating through the array,

         */
        MaxBitwiseAnd maxBitwiseAnd = new MaxBitwiseAnd();
        int count = maxBitwiseAnd.longestSubarray(nums);
        System.out.println("Count of maximum bitwise AND subsets: " + count); // Output: 2
    }



public int longestSubarray(int[] nums) {
    int maxBit = 0;
    int maxLength = 0;
    int currentLength = 0;
    if (nums.length != 0) {
        for (int num : nums) {
            if (num > maxBit) {
                maxBit = num;
            }
        }

        // count the occurrence of maxBit in the array


        for (int n : nums) {
            if (n == maxBit) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 0;
            }
        }
    }
    return maxLength;
}
}
