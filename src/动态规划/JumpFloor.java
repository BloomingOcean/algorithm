package 动态规划;

/**
 * 跳台阶、青蛙跳台阶、最小花费爬楼梯
 * @Author Li Yang
 * @Date 22/03/30 14:50
 * @Version 1.0
 *
 * 描述：
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * 数据范围：1 ≤ n ≤ 40
 * 要求：时间复杂度：O(n)，空间复杂度：O(1)
 */
public class JumpFloor {

    public static void main(String[] args) {
        System.out.println(jumpFloor1(6));
//        System.out.println(jumpFloorDynamic(7));
//        System.out.println(jumpFloorOptimization(7));
    }
    public static int jumpFloor1(int target) {
        // 动态规划，先从小问题入手
        int[] dp = new int[40];
        dp[0] = 1;
        dp[1] = 1;
//         dp[2] = 2;
        for(int i=2; i<=target; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[target];
    }
    /**
     * 递推
     * 原理：逆推
     * 在第n层时，往下跳的情况有两种，一种是往下跳一层，另一种情况是往下跳两层
     * 第一种情况是第一步只跳一层：那么在跳到(n-1)层的时候，又往下跳，有几种可能？那就有f(n-1)种
     * 第二种情况是第一步跳两层：那么在跳到(n-2)层的时候，又往下跳，有几种可能？那就有f(n-2)种
     * 所以在n层时的可能就是 f(n) = f(n-1) + f(n-2)
     * 同理，如果青蛙能一次跳1,2,3层，那么就是f(n) = f(n-1) + f(n-2) + f(n-3)
     *
     * @param floor
     * @return
     */
    public static int jumpFloor(int floor) {
        if(floor <= 1){
            return 1;
        }
        return jumpFloor(floor-1) + jumpFloor(floor-2);
    }

    /**
     * 青蛙可以跳1，2，3层，那么需要特殊考虑，如果只剩2层时的情况
     * 否则f(2) = f(1) + f(0) + f(-1)就会超出
     * @param floor
     * @return
     */
    public static int jumpFloor3(int floor) {
        if(floor == 2){
            return 2;
        }
        if(floor <= 1){
            return 1;
        }
        return jumpFloor3(floor-1) + jumpFloor3(floor-2) + jumpFloor3(floor-3);
    }

    /**
     * 动态规划
     *
     * 比递归优化的地方：
     * 比起递归，如果想让空间继续优化，那就用动态规划，优化掉 **递归栈空间**。
     * 方法二是从上往下递归的然后再从下往上回溯的，最后回溯的时候来合并子树从而求得答案。
     * 那么动态规划不同的是，不用递归的过程，直接从子树求得答案。过程是从下往上。
     *
     * @return 和
     */
    public static int jumpFloorDynamic(int floor){
         int[] dp = new int[40];
         dp[0] = 1; // 这是0层！！！！不是1层！！
         dp[1] = 1; // 这才是1层
        for (int i = 2; i <= floor; i++) {
            // 迈出1步的可能性数量 + 迈出2步的可能性数量
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[floor];
    }

    /**
     * 动态规划优化
     * 由于只需要f(n-1)和f(n-2)这两个数据，所以可以只定义3个变量
     * 分别存储这两个数据和总和
     * ps：如果青蛙可以跳1，2，3，则需要定义4个
     *
     * @param n x
     * @return 和
     */
    public static int jumpFloorOptimization(int n){
       int f1=1,f2=1,sum=0;
       // 假设可以跳3阶
        int f3=2;
        // 从f3开始计算
        for (int i = 3; i < n; i++) {
            sum = f1 + f2;
            f1 = f2;
            // 此时sum==f3
            f2 = sum;
        }
        return sum;
    }
}
