package 美团;

import java.util.Scanner;

/**
 * @Author Li Yang
 * @Date 22/04/02 9:53
 * @Version 1.0
 */
public class Main1 {
    /**
     * 双色球
     *
     * 第一行有三个正整数，n，r，b，分别代表桌上球的数量，口袋里红球的数量，和口袋里蓝球的数量。
     *
     * 这三个数的大小均不超过100000。
     *
     * 第二行有一个长度为n的仅由r和b组成的字符串。
     * 第i个字符代表桌上这一列球中的第i个的颜色是红色还是蓝色；红色则为r，蓝色则为b。
     * @param args
     */
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int table = sc.nextInt();
//        int red = sc.nextInt();
//        int blue = sc.nextInt();
//        String tableBall = sc.nextLine();

        int table = 5;
        int red = 2;
        int blue = 1;
        String tableBall = "rrbbr";

        char[] chars = tableBall.toCharArray();
        int len = chars.length + red + blue;
        char[] newChar = new char[len];
        StringBuffer buffer = new StringBuffer();

        for (int i = 0, j=0; i < chars.length-1; i++) {
            buffer.append(chars[i]);
//            newChar[j] = chars[i];
//            j++;
            if(chars[i] == chars[i+1]){
                if(chars[i+1] == 'r'){
                    if(blue>0){
                        buffer.append('b');
//                        newChar[j] = 'b';
//                        j++;
                    }
                    blue--;
                } else if(chars[i+1] == 'b'){
                    if(red>0){
                        buffer.append('r');
//                        newChar[j] = 'r';
//                        j++;
                    }
                    red--;
                }
            }
        }

        if(blue>=0 && red>=0){
            System.out.println(buffer.length());
        } else {
            if(blue<0 && red>=0){
                blue = Math.abs(--blue);
                System.out.print(blue + '\t');
                System.out.print(0);
            }
            if(blue<0 && red<0){
                blue = Math.abs(--blue);
                red = Math.abs(--red);
                System.out.print(blue + '\t');
                System.out.print(red);
            }
            if(blue>=0 && red<0){
                red = Math.abs(--red);
                System.out.print(0 + '\t');
                System.out.print(red);
            }
        }
    }
}
