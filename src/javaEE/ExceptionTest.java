package javaEE;

/**
 * @Author Li Yang
 * @Date 22/04/08 11:53
 * @Version 1.0
 */
public class ExceptionTest {

    public static void main(String[] args) {
        System.out.println(ecRe());
    }

    public static int ecRe(){
        try{
            throw new Exception();
//            System.out.println(1);
//            return 1;
        }catch (Exception e){
            System.out.println("catch");
            e.printStackTrace();
            System.out.println("catch-after");
            // 猜测本来返回的就是2，但是被finally的return覆盖值了
            return 2;
        }finally {
            System.out.println("finally");
            return 1;
        }
//        return 0;
    }
}
