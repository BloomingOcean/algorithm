package 动态规划;

/**
 * 斐波那契数列
 * @Author Li Yang
 * @Date 22/03/30 14:31
 * @Version 1.0
 * 描述：
 * 大家都知道斐波那契数列，现在要求输入一个正整数 n, 请你输出斐波那契数列的第 n 项。
 *
 *
 * 斐波那契数列是一个满足
 * fib(x) =     { 1                    x=1,2
 *              { fib(x-1) + fib(x-2)  x>2
 *
 *
 * 数据范围：1 ≤ n ≤ 40
 * 要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n) ，本题也有时间复杂度 O(logn)O(logn) 的解法
 */
public class Fibonacci {

    public static void main(String[] args) {
        // 动态规划
        System.out.println(fibonacci(6));

        // 动态规划优化
//        System.out.println(fibonacciOptimization(6));

        /** ====递归====
         * 使用递归最重要的就是1、基准条件2、递推规律or公式
         * 斐波那契之所以简单，是因为基准条件和递推公式已经在题目条件中有了
         */
//        System.out.println(fibonacciRecursion(6));
    }

    /**
     * 动态规划优化
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * 优化原理：每次计算一个新数时，只会用上fib(x-1)和fib(x-2)这两个数
     * 所以尝试只保存这两个数和一个总和数
     *
     * @param n x
     * @return 和
     */
    public static int fibonacciOptimization(int n){
        int f1=1, f2=1, sum = 0;
        // 从第三位才开始计算的，要去除掉f1和f2的计算过程
        for (int i = 3; i <= n; i++) {
            sum = f1 + f2;
            // 都变为了后一个数字，挪动了一位
            f2 = f1;
            f1 = sum;
        }
        return sum;
    }

    /**
     * 动态规划
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param n x
     * @return 和
     */
    public static int fibonacci(int n){
        // 数据范围：1 ≤ n ≤ 40
        int[] dp = new int[50];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * 我就这么说吧，用递归的都是弟弟
     * @param n x
     * @return 和
     */
    public static int fibonacciRecursion(int n){
        if(n <= 2){
            return 1;
        }
        return fibonacciRecursion(n-1) + fibonacciRecursion(n-2);
    }
}
