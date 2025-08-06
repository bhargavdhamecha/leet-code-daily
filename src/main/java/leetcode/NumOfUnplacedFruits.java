package leetcode;

/**
 * <h1>num-of-unplaced-fruits</h1>
 * @link: https://leetcode.com/problems/fruits-into-baskets-ii
 */
public class NumOfUnplacedFruits {
    public static void main(String[] args) {
        int[] fruits = {4,2,5};
        int[] baskets = {3,5,4};
        NumOfUnplacedFruits n = new NumOfUnplacedFruits();
        System.out.println("unplaced fruits: "+n.numOfUnplacedFruits(fruits, baskets));
    }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int totalFruits = fruits.length;
        for (int f: fruits){
            if(canPlace(baskets, f)){
                totalFruits--;
            }
        }

        return totalFruits;
    }

    public boolean canPlace(int[] baskets, int fruit) {
        for (int i = 0; i < baskets.length; i++) {
            if (fruit <= baskets[i]) {
                baskets[i] = -1;
                return true;
            }
        }
        return false; // No basket can hold the fruit
    }
}
