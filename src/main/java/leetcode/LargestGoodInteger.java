package leetcode;

import java.util.*;

/**
 * @link: https://leetcode.com/problems/largest-3-same-digit-number-in-string
 */
public class LargestGoodInteger {
    public static void main(String[] args) {
        LargestGoodInteger lg = new LargestGoodInteger();
        System.out.println("largest num: "+lg.largestGoodInteger("42352338"));
    }

    public String largestGoodInteger(String num) {
        char maxChar = 0;
        for (int i = 0; i < num.length() - 2; i++) {
            char c = num.charAt(i);
            if (c == num.charAt(i + 1) && c == num.charAt(i + 2)) {
                if (c > maxChar) {
                    maxChar = c;
                }
            }
        }
        return maxChar == 0 ? "" : "" + maxChar + maxChar + maxChar;
    }


    // TODO: check this optimized solution
    public String largestGoodInteger1(String num) {
        int n = num.length();
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n-2;i++) {
            if(num.charAt(i)==num.charAt(i+1) && num.charAt(i)==num.charAt(i+2)) {
                int x = num.charAt(i)-'0';
                int formed = x*100+x*10+x;
                if(formed>ans) ans = formed;
            }
        }
        if(ans == Integer.MIN_VALUE) return "";
        if(ans==0) return "000";
        return String.valueOf(ans);
    }
}
