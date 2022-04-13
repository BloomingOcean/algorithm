package 牛客面试必刷TOP101.二分查找or排序;

/**
 * @Author Li Yang
 * @Date 22/04/13 14:25
 * @Version 1.0
 */
public class BM18_二维数组中的查找 {

    public static void main(String[] args) {
        int[][] array = {{1,2,8,9},
                         {2,4,9,12},
                         {4,7,10,13},
                         {6,8,11,15}};
        System.out.println(Find(7, array));
    }

    /**
     * 1、想象从四个角开始判断
     * 1-1、左上角(0,0)，如果大于(0,0)，无法判断是在横排还是在竖排，不行
     * 1-2、右上角，(len-1,0),如果大于(len-1,0),则这一排可以排除，往下移动，可选
     * 1-3、左下角，(0,len-1),如果大于(0,len-1),则这一列可以排除，往右移动，可选
     * 1-4、右下角，(len-1,len-1),如果小于(len-1,len-1),无法判断target是在横排还是竖排，不行
     * @param target 找的数字
     * @param array 数组
     * @return 数字
     */
    public static boolean Find(int target, int [][] array) {
        // 行
        int len = array.length-1;
        /**
         * 你咋又忘了边界条件？？？
         */
        if(len == 0){
            return false;
        }
        // 列
        int wid = array[0].length-1;
        int y=0,x=wid;
//        int cur = array[y][x];
        while(target != array[y][x]) {
            if(array[y][x] < target){
                if(y<len){
                    y++;
                } else {
                    return false;
                }
            } else if(array[y][x] > target){
                if(x>0){
                    x--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
