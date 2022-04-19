package 数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @Author Li Yang
 * @Date 22/04/08 22:34
 * @Version 1.0
 */
public class 剑指_easy_39_数组中超过一半的数 {
    /**
     * 描述
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
     * 输出: 2
     *
     * 限制：
     * 1 <= 数组长度 <= 50000
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElementVote(nums));
    }

    /**
     * 推荐此算法：简单实用
     * Boyer-Moore 投票算法
     * @param nums nums
     * @return 多数
     */
    public static int majorityElementVote(int[] nums) {
        int candidate = 0, count = 0;
        for (int num : nums) {
            if(count == 0){
                candidate = num;
                count++;
            } else if(num == candidate){
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    /**
     * 哈希表
     * 时间复杂度O(2n)
     * 空间复杂度O(n)
     * @param nums nums
     * @return 多数
     */
    public static int majorityElementHash(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int num : nums) {
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }
        Iterator<Integer> it = map.keySet().iterator();
        int half = len/2;
        while(it.hasNext()){
            Integer key = it.next();
            if(map.get(key) > half){
                return key;
            }
        }
        return -1;
    }

    /**
     * 排序，在中间的肯定是多数
     * @param nums nums
     * @return 多数
     */
    public static int majorityElementSort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }


}
