package 牛客面试必刷TOP101.二分查找or排序;

/**
 * @Author Li Yang
 * @Date 22/05/08 15:03
 * @Version 1.0
 */
public class BM21_旋转数组的最小数字 {

    /**
     * 有一个长度为 n 的非降序数组，比如[1,2,3,4,5]，将它进行旋转，
     * 即把一个数组最开始的若干个元素搬到数组的末尾，变成一个旋转数组，
     * 比如变成了[3,4,5,1,2]，或者[4,5,1,2,3]这样的。
     * 请问，给定这样一个旋转数组，求数组中的最小值。
     * @param args 数组
     */
    public static void main(String[] args) {

    }

    /**
     * 思路：找到的第一个 arr[i] > arr[i+1]的那个数，那么这个数就是最小值
     * 实现方法1：遍历，时间复杂度是0(n)，空间复杂度是1
     * 实现方法2：二分法，直到逼近衔接数值，时间复杂度为0(logn)
     * @param array 数组
     * @return 最小值
     */
    public int minNumberInRotateArray(int [] array) {
        int left = 0;
        int len = array.length;
        int right = len-1;

        while(right > left) {
            int mid = (right - left)/2 + left;
            if(array[mid] > array[right]) {
                // 最后一步例如left=0，right=1时，如果是left = mid
                // 则left永远都会只是0，所以需要在原先的基础上加上一个变动
                left = mid+1;
            } else if(array[mid] < array[right]){
                right = mid;
            } else {
                right--;
            }
        }
        return array[left];
    }

}
