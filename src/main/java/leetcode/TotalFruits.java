package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>fruit-into-baskets</h1>
 * @link: https://leetcode.com/problems/fruit-into-baskets/
 */
public class TotalFruits {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 2, 3, 3};
        TotalFruits t = new TotalFruits();
        System.out.println("result: " + t.totalFruit(arr));
    }

    public int totalFruit(int[] fruits) {
        Map <Integer, Integer> basket = new HashMap<>();
        int left = 0, maxFruits = 0;

        for (int right = 0; right < fruits.length; right++) {
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

            // If there are more than 2 types of fruits, shrink the window
            while (basket.size() > 2) {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if (basket.get(fruits[left]) == 0) {
                    basket.remove(fruits[left]);
                }
                left++;
            }

            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }
}
