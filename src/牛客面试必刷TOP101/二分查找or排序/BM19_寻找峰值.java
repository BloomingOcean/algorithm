package 牛客面试必刷TOP101.二分查找or排序;

/**
 * @Author Li Yang
 * @Date 22/04/19 10:24
 * @Version 1.0
 */
public class BM19_寻找峰值 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,4,1,2,7,8,4};
        System.out.println(findPeakElement(nums));
    }

    /**
     * 关键思想：下坡的时候可能找到波峰，但是可能找不到，一直向下走的
     * 上坡的时候一定能找到波峰，因为题目给出的是nums[-1] = nums[n] = -∞
     * @param nums 数组
     * @return 峰值
     */
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while(left < right) {
            mid = (right-left)/2 + left;
            // 下坡路（抛弃）
            if(nums[mid] > nums[mid+1]) {
                right = mid;
            } else { // 上坡路（必有峰）
                left = mid + 1;
            }
        }
        return right;
    }
}
