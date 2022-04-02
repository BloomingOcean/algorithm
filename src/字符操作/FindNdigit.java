import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * 题目描述
 * 给你一个整数 n ，请你在无限的整数序列
 * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位上的数字。
 *
 * 示例：
 * 输入：n = 11
 * 输出：0
 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 *                                              数字10的第一位1是第10位
 *                                              数字10的第二位0是第11位
 *
 *
 *  ========注: 1 <= n <= 2的23次方 - 1========
 */
class Solution {
    /**
     * 这种遍历的方法，超时了！！！！！
     * @param n 第n位
     * @return n位的数字
     */
    public int findNdigit(int n) {
        int shulie = 1;
        while (true) {
            char[] array = Integer.toString(shulie).toCharArray();
            int len = array.length;
            for (int i = 0; i < len; i++) {
                n--;
                if(n==1){
                    System.out.println();
                }
                if (n == 0) {
                    /**
                     * 字符数字 转成整型数字的简便方法
                     */
                    return array[i]-'0';
                    // 老办法
//                    return Integer.parseInt(Character.toString(array[i]));
                }
            }
            shulie++;
        }
    }

    public static class FindNdigit {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int res;

            int _n;
//            _n = Integer.parseInt(in.nextLine().trim());

            res = new Solution().findNdigit(190);
            System.out.println(String.valueOf(res));

        }
    }
}