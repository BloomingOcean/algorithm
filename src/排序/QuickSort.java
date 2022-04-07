package 排序;

import java.io.IOException;
import java.util.Arrays;

/**
 * @Author Li Yang
 * @Date 22/03/06 15:26
 * @Version 1.0
 * 参考1（挖坑大法）：https://juejin.cn/post/6844903642042990599
 * 参考2（挖坑视频）：https://www.bilibili.com/video/BV1at411T75o
 * 参考2（交换大法）：https://zhuanlan.zhihu.com/p/373348669
 */
public class QuickSort {

    private int max;

    public static void main(String[] args) throws IOException {
        int[] nums = new int[]{12,1,6,64,23,4,25,5,26,2,52,72,42,55,62,7,8,24};
//        int[] nums1 = new int[]{12,1,6,64,23};
//        quickSort3(nums, 0, nums.length-1);
//        System.out.println(Arrays.toString(nums));
        quickSortTraverse(nums, 0, nums.length -1);
        System.out.println("排序后的结果");
        System.out.println(Arrays.toString(nums));

        /**
         * 重中之重，需要注意***
         * 在同一个位置实现交换采用异或的方式，会造成数据丢失
         */
//        int[] arr = new int[]{12,12};
//        System.out.println(arr[0] + " " + arr[1]);
//        arr[0] = arr[0] ^ arr[0];
//        arr[0] = arr[0] ^ arr[0];
//        arr[0] = arr[0] ^ arr[0];
//        System.out.println(arr[0] + " " + arr[1]);
    }

    /**
     * 挖坑大法
     * 注：指针是左右向中间并拢
     * @param nums
     * @param left
     * @param right
     */
    public static void quickSort(int[] nums, int left, int right){
        if (nums == null || left >= right || nums.length <= 1)
            return;

        // 基准值
        // 挖坑
        int pivot = nums[left];

        int lp=left;
        int rp=right;

        // 试试挖坑理论 + 分治
        // 就不应该先遍历左边，而是先遍历右边
        while(lp < rp){
            // 寻找右边第一个小于基准值的数
            // 退出此循环有两种可能
            // 1、rp指到了小于基准值的数
            // 2、lp 和 rp相等了
            while(nums[rp]>=pivot && lp<rp){
                rp--;
            }

            // 填坑
            if(nums[rp]<pivot){
                nums[lp] = nums[rp];
            }

            // 寻找左边第一个大于基准值的数
            // 退出此循环有两种可能
            // 1、lp指到了大于基准值的数
            // 2、lp 和 rp相等了
            while(nums[lp]<=pivot && lp<rp){
                lp++;
            }

            // 填坑
            if(nums[lp]>pivot){
                nums[rp] = nums[lp];
            }

            // 此时nums[lp]的值在数组中有一个多余重复值
            // 用pivot来填坑
            // 填坑
            if(lp == rp){

                nums[lp] = pivot;
                break;
            }
        }

        // 继续相同的操作
        quickSort(nums, left, lp-1);
        quickSort(nums, rp+1, right);
    }

    /**
     * 挖坑大法-复习-优化
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort2(int[] arr, int left, int right){
        // left==right时，只有一个元素需要排列，也就不需要排列
        if(arr == null || arr.length <= 1 || left >= right){
            return;
        }

        // 基准值
        // 挖坑
        int pivot=arr[left];

        int lp=left;
        int rp=right;

        while (lp < rp){
            // 因为基准值是从left中选取，所以先从右边往左边填坑
            // 两指针在互相逼近时，如果是逼近最右边，最终就无法使基准值覆盖最右指针
            for (; rp > lp; rp--) {
                if(arr[rp] < pivot){
                    // 填坑
                    arr[lp] = arr[rp];
                    break;
                }
            }

            for (; lp < rp; lp++) {
                if(arr[lp] > pivot){
                    // 填坑
                    arr[rp] = arr[lp];
                    break;
                }
            }

            if(lp == rp){
                arr[lp] = pivot;
            }

            // 此时lp和rp指向同一个位置，使用谁都行
            // 左半
            quickSort2(arr, left, lp-1);
            // 右半
            quickSort2(arr, lp+1, right);
        }

    }

    /**
     * 交换大法
     * 注：指针是同一个方向的走势，一个指向大于pivot，另一个指向小于pivot
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort3(int[] arr, int left, int right){
        // left==right时，只有一个元素需要排列，也就不需要排列
        if(arr == null || arr.length <= 1 || left >= right){
            return;
        }

        int pivot=arr[left];

        // 指向小于pivot
        int small=left+1;
        // 指向大于pivot
        int big=left;

        // 默认从左往右以从小到大的顺序
        // 则留守指针需要是big指针，否则是small指针
        while(small <= right){
            // 注：small和big之间的值，必然大于pivot
             while(small <= right && arr[small] >= pivot){
                small++;
            }
            if(small>right){
                break;
            }
            // 特殊：如果第0个值小于pivot，则交换自己，然后两指针都往后一步
            int temp = arr[small];
            arr[small] = arr[big];
            arr[big] = temp;
//            arr[big] = arr[small] ^ arr[big];
//            arr[small] = arr[small] ^ arr[big];
//            arr[big] = arr[small] ^ arr[big];
            big++;
            small++;
        }

        // 最终small把数组全部遍历完
        // 此时big指针之前的就是小于pivot的值
        // big指针之后的就是大于pivot的值
        // 并且此时big指向的是最后一个小于pivot的值
        // 例如{pivot=5, 1, 4, 2, 6, 23, 13}
        // big 指向2
        // small 指向13

        // 交换pivot和第一个大于pivot前的值
        arr[big] = arr[left] ^ arr[big];
        arr[left] = arr[left] ^ arr[big];
        arr[big] = arr[left] ^ arr[big];

        quickSort3(arr, left, big-1);
        quickSort3(arr, big+1, right);

    }

    public static int partition(int[] array, int low, int high) {
        // 取最后一个元素作为中心元素
        int pivot = array[high];
        // 定义指向比中心元素大的指针，首先指向第一个元素
        int pointer = low;
        // 遍历数组中的所有元素，将比中心元素大的放在右边，比中心元素小的放在左边
        for (int i = low; i < high; i++) {
            if (array[i] <= pivot) {
                // 将比中心元素小的元素和指针指向的元素交换位置
                // 如果第一个元素比中心元素小，这里就是自己和自己交换位置，指针和索引都向下一位移动
                // 如果元素比中心元素大，索引向下移动，指针指向这个较大的元素，直到找到比中心元素小的元素，并交换位置，指针向下移动
                int temp = array[i];
                array[i] = array[pointer];
                array[pointer] = temp;
                pointer++;
            }
            System.out.println(Arrays.toString(array)+" i:"+i + " pointer:" +pointer);
        }
        // 将中心元素和指针指向的元素交换位置
        int temp = array[pointer];
        array[pointer] = array[high];
        array[high] = temp;
        return pointer;
    }

    public static void quickSort4(int[] array, int low, int high) {
        if (low < high) {
            // 获取划分子数组的位置
            int position = partition(array, low, high);
            // 左子数组递归调用
            quickSort4(array, low, position -1);
            // 右子数组递归调用
            quickSort4(array, position + 1, high);
        }
    }


    /**
     * 快排遍历写法的自我实现
     * @param arr 数组
     * @param left 左
     * @param right 右
     */
    public static void quickSortTraverse(int[] arr, int left, int right){
        // 找分组的地儿
        if (left < right){
            int partition = partition2(arr, left, right);
            // 左边儿
            quickSortTraverse(arr, left, partition - 1);
            // 右边儿
            quickSortTraverse(arr, partition + 1, right);
        }
    }

    public static int partition2(int[] arr, int left, int right){
        // 基准值-选取最右边的值
        int pivot = arr[right];

        // 左指针(指向大于pivot的值)
        int pointer = left;
        // i用于指向小于pivot的值(快指针)
        for(int i = left; i < right; i++){
            if(arr[i] <= pivot){
                /**
                 * 重中之重，需要注意***
                 * 在同一个位置实现交换采用异或的方式，会造成数据丢失
                 */
//                arr[i] = arr[pointer] ^ arr[i];
//                arr[pointer] = arr[pointer] ^ arr[i];
//                arr[i] = arr[pointer] ^ arr[i];
                // 交换
                int temp = arr[i];
                arr[i] = arr[pointer];
                arr[pointer] = temp;
                pointer++;
            }
        }
        // 此时pointer指向中间的位置
        // i指向最右边的位置-也就是pivot的位置
        // 赋值
        int temp = arr[pointer];
        arr[pointer] = arr[right];
        arr[right] = temp;

        return pointer;
    }
}