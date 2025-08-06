package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * using top-bottom (memoization approach)
 * to memorize answer used hashmap here to get the result of already calculated value
 * do not calculate each and every value, instead of get it from memory;
 */
public class PascalTri {
    HashMap<String, Integer> memo = new HashMap<>();
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        PascalTri p = new PascalTri();
        int num = 5;
        for (int i = 1; i <= num; i++) {
            p.prepareRow(i ,result);
        }
        System.out.println("answer: "+ result);
    }

    public void prepareRow(int currentRow,List<List<Integer>> res){
        List<Integer> ls = new ArrayList<>();
        for (int i = 1; i <= currentRow; i++) {
            ls.add(calculateValue(currentRow, i));
        }
        res.add(ls);
    }

    public int calculateValue(int row, int col){
        if(col == 1 || col == row){
           return  1;
        }
        else{
            String key = row+"_"+col;
            if(memo.containsKey(key)){
                return memo.get(key);
            }
            int val = calculateValue(row-1, col-1) + calculateValue(row-1, col);
            memo.put(key, val);
            return val;
        }
    }
}
