package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * instead using hashMap to store the value, use 2d array.
 */
public class PascalTriEfficient {
    public static int[][] memo;
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        PascalTri p = new PascalTri();
        int num = 5;
        memo = new int[num+1][num+1];
        for (int[] r: memo){
            Arrays.fill(r, -1);
        }
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
            if(memo[row][col]!= -1){
                return memo[row][col];
            }
            int val = calculateValue(row-1, col-1) + calculateValue(row-1, col);
            memo[row][col] = val;
            return val;
        }
    }
}
