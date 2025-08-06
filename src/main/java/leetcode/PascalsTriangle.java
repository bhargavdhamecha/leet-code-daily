package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PascalsTriangle {
    public Map<String, Integer> memoMap = new HashMap<>();
    public static void main(String[] args) {
        PascalsTriangle ps = new PascalsTriangle();
        List<List<Integer>> ls = ps.generate(5);
        System.out.println("result: " + ls);
//        for (int i = 0; i < ls.size(); i++) {
//            for (int j = 0; j < ls.get(i).size(); j++) {
//                System.out.printf(ls.get(i));
//            }
//        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }
            }
            triangle.add(row);
        }
        return triangle;
    }
}
