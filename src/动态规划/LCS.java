package 动态规划;

/**
 * @Author Li Yang
 * @Date 22/03/31 0:08
 * @Version 1.0
 */
public class LCS {

    public static void main(String[] args) {
//        System.out.println(LCS("12345EF", "1AB2345CD"));
//        System.out.println(LCS("2LQ74WK8Ld0x7d8FP8l61pD7Wsz1E9xOMp920hM948eGjL9Kb5KJt80", "U08U29zzuodz16CBZ8xfpmmn5SKD80smJbK83F2T37JRqYfE76vh6hrE451uFQ100ye9hog1Y52LDk0L52SuD948eGjLz0htzd5YF9J1Y6oI7562z4T2"));
//        System.out.println(LCSoptimization("2LQ74WK8Ld0x7d8FP8l61pD7Wsz1E9xOMp920hM948eGjL9Kb5KJt80", "U08U29zzuodz16CBZ8xfpmmn5SKD80smJbK83F2T37JRqYfE76vh6hrE451uFQ100ye9hog1Y52LDk0L52SuD948eGjLz0htzd5YF9J1Y6oI7562z4T2"));
        System.out.println(LCSoptimization("22222", "22222"));
    }

    /**
     * 动态规划
     * 要点：
     * 创建dp时，需要创建没有任何字母的那一列和行，这样在处理真正第一个字母的时候才可以沿用前面已有的数据
     * @param str1
     * @param str2
     * @return
     */
    public static String LCS (String str1, String str2) {
        // write code here
        int len1 = str1.length();
        int len2 = str2.length();
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        /**
         * 这里需要把第0列和行创建出来，否则不便于迭代第一行（不然第一行和第一列需要特殊考虑）
         */
        int[][] dp = new int[len1+1][len2+1];

        int maxCount = 0;
        int maxIndex = 0;
        // i=0时表示没有字符
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if(arr1[i] == arr2[j]){
                    // dp[i][i]代表左上角那个数
                    dp[i+1][j+1] = dp[i][j] + 1;
                    if(maxCount < dp[i+1][j+1]){
                        maxCount = dp[i+1][j+1];
                        maxIndex = j+1;
                    }
                } else {
                    dp[i+1][j+1] = 0;
                }
//                System.out.println(i + " " + j);;
//                prin(dp);
//                System.out.println();;
            }
        }
        return str2.substring(maxIndex-maxCount, maxIndex);
    }

//    public static void prin(int[][] arr){
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println("");
//        }
//    }

    /**
     * 优化动态规划
     * 原理：
     * 每次进行新行的更新时，其实只需要上一行的数据，所以只存储上一行的数据就好
     * @param str1
     * @param str2
     * @return
     */
    public static String LCSoptimization (String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        int[] dp = new int[len2+1];

        int maxLen = 0;
        int maxIndex = 0;
        for (int i = 0; i < len1; i++) {
            /**
             * 需要的左上的数据，如果从左往右遍历，会把左上的数据覆盖掉
             * 数据结构示例：
             * 
             * 0 1 2 3/ 0 0 1 0 1 0
             * 如果程序进行到3这个位置，那么3左边的数据是前一排的数据，3后边的是此排数据
             * 
             * 注：进行轮询的时候，把i想象成机械手表盘上可以上下转动的星期日
             * 每个星期日都和右边的数据匹配
             */
            for (int j = len2-1; j >= 0; j--) {
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[j+1] = dp[j] + 1;
                    if(dp[j+1] > maxLen){
                        maxLen = dp[j+1];
                        maxIndex = j+1;
                    }
                } else {
                    dp[j] = 0;
                }
            }
        }
        /**
         * substring: 左闭右开
         */
        return str2.substring(maxIndex-maxLen, maxIndex);
    }

}
