package leetcode;

import java.util.*;

/**
 * used EDITORIAL in this solution.
 * TODO: try to understand it and implement it on your own.
 * need to find out which one index to switch such that the both baskets have equal value.
 * that should be minimum.
 * if not possible, then return -1.
 *
 * SPOILER ALERT - Don't read on if you don't want a hint.
 * If you need a hint, then consider these two test cases:
 * [2,2,100,100],[3,3,200,200] (answer 5) // total_1: 204, total_2: 406
 * after swap: [3,2,200,100],  [2,3,100,200] //total_1: 205: total_2: 205, index 0, 2
 * [1,100,100],[1,200,200] (answer 2) // total_1: 201, total_2: 401
 */
public class RearrangingFruits {

    public static void main(String[] args) {
        RearrangingFruits rearrangingFruits = new RearrangingFruits();
        int[] basket1 = {2,2,100,100}; // total = 10
        int[] basket2 = {3,3,200,200}; // total = 8
        long result = rearrangingFruits.minCost(basket1, basket2);
        System.out.println("Minimum cost to rearrange fruits: " + result); // Output: 1
    }

    public long minCost(int[] basket1, int[] basket2) {
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        int m = Integer.MAX_VALUE;
        for (int b1 : basket1) {
            freq.put(b1, freq.getOrDefault(b1, 0) + 1);
            m = Math.min(m, b1);
        }
        for (int b2 : basket2) {
            freq.put(b2, freq.getOrDefault(b2, 0) - 1);
            m = Math.min(m, b2);
        }

        List<Integer> merge = new ArrayList<>();
        for (var entry : freq.entrySet()) {
            int count = entry.getValue();
            if (count % 2 != 0) return -1;
            for (int i = 0; i < Math.abs(count) / 2; i++) {
                merge.add(entry.getKey());
            }
        }

        Collections.sort(merge);
        long res = 0;
        for (int i = 0; i < merge.size() / 2; i++) {
            res += Math.min(2 * m, merge.get(i));
        }
        return res;
    }
}
