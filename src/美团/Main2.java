package 美团;

import java.util.Scanner;

/**
 * @Author Li Yang
 * @Date 22/04/02 10:39
 * @Version 1.0
 */
public class Main2 {
    /**
     * 单峰数组
     *
     * 小美有一个长度为n的数组。小美觉得如果一个数组可以从中切开，使得前一段严格递增且后一段严格递减，那么这个数组是好的。
     * 现在小美想通过往她所有的数组的某些元素上加上总和尽可能小的一些正整数从而让这个数组变好。
     * 请你求出她需要加上总和至少为多少的正整数才能使数组变好。
     * 一个数组是严格递增的当且仅当其中除第一个元素以外的任意一个元素都大于其前一个元素。
     * 一个数组是严格递减的当且仅当其中除第一个元素以外的任意一个元素都小于其前一个元素。
     *
     * 样例输入
     * 5
     * 1 2 1 2 1
     * 样例输出
     * 2
     *
     * 提示
     * 如样例中将往中间的1加上2即可使数组变成1,2,3,2,1。
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int number = sc.nextInt();
//        int[] nums = new int[number];
//        for (int j = 0; j < number; j++) {
//            nums[j] = sc.nextInt();
//        }

        int number = 8;
        int[] nums = new int[]{1,2,1,2,1,4,6,7};
        // 1+2 2+2
        //

        int mid = number/2;
        int sum = 0;
        for (int i = 1; i < mid; i++) {
            if(nums[i] <= nums[i-1]){
                int t = nums[i-1] - nums[i] + 1;
                nums[i] += t;
                sum += t;
            }
        }
        for (int i = mid+1; i < nums.length; i++) {
            if(nums[i] >= nums[i-1]){
                int t = nums[i] - nums[i-1] + 1;
                nums[i] += t;
                sum += t;
            }
        }
        System.out.println(sum);
    }
}
