package leetcode;

/**
 * @link: https://leetcode.com/problems/maximum-69-number/?envType=daily-question&envId=2025-08-16
 */
public class Maximum69Number {
    public static void main(String[] args) {
        Maximum69Number number = new Maximum69Number();
        System.out.println("max num: " + number.maximum69Number(9669));
    }

    public int maximum69Number (int num) {
        String str = String.valueOf(num);
        boolean replaced = false;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '6' && !replaced){
                replaced = true;
                str=str.replaceFirst("6", "9");
            }
        }
        return Integer.parseInt(str);
    }

}
