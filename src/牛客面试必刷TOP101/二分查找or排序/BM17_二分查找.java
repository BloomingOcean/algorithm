package 牛客面试必刷TOP101.二分查找or排序;

/**
 * @Author Li Yang
 * @Date 22/04/13 11:54
 * @Version 1.0
 */
public class BM17_二分查找 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 4, 6, 10, 13, 14};
//        int[] nums = {1};
        System.out.println(search(nums, 13));
    }

    public static int search (int[] nums, int target) {
        // write code here
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
