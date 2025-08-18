package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO: check and understand this copied solution.
 * @link: https://leetcode.com/problems/24-game/?envType=daily-question&envId=2025-08-18
 */
public class JudgePoint24 {
    public static void main(String[] args) {
        Solution j = new Solution();
        System.out.println("res: " + j.judgePoint24(new int[]{4,1,8,7}));
    }


    static class Solution {
        private static final double EPS = 1e-6;

        public boolean judgePoint24(int[] cards) {
            List<Double> nums = new ArrayList<>();
            for (int num : cards) {
                nums.add((double) num);
            }
            return dfs(nums);
        }

        private boolean dfs(List<Double> nums) {
            int n = nums.size();
            if (n == 1) {
                return Math.abs(nums.get(0) - 24.0) < EPS;
            }
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    double a = nums.get(i), b = nums.get(j);
                    List<Double> next = new ArrayList<>();
                    for (int k = 0; k < n; k++) {
                        if (k != i && k != j) next.add(nums.get(k));
                    }
                    for (double val : generateResults(a, b)) {
                        next.add(val);
                        if (dfs(next)) return true;
                        next.remove(next.size() - 1);
                    }
                }
            }
            return false;
        }

        private List<Double> generateResults(double a, double b) {
            List<Double> res = new ArrayList<>();
            res.add(a + b);
            res.add(a - b);
            res.add(b - a);
            res.add(a * b);
            if (Math.abs(b) > EPS) res.add(a / b);
            if (Math.abs(a) > EPS) res.add(b / a);
            return res;
        }
    }


}
