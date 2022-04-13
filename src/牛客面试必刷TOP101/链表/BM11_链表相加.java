package 牛客面试必刷TOP101.链表;

import java.util.LinkedList;

/**
 * @Author Li Yang
 * @Date 22/04/13 11:25
 * @Version 1.0
 */
public class BM11_链表相加 {
    public static void main(String[] args) {

    }

    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }

    /**
     * 入栈方式
     * @param head1 链表1
     * @param head2 链表2
     * @return 相同结点
     */
    public static ListNode addInList (ListNode head1, ListNode head2) {
        LinkedList<Integer> list1 = new LinkedList<>(); //list1栈
        LinkedList<Integer> list2 = new LinkedList<>(); //list2栈
        putData(list1, head1); //入栈
        putData(list2, head2);
        ListNode newNode = null;
        ListNode head = null;
        int carry = 0; //标记进位
        while(!list1.isEmpty() || ! list2.isEmpty() || carry != 0) {
            int x = (list1.isEmpty()) ? 0 : list1.pop();  //依次从栈中取出
            int y = (list2.isEmpty()) ? 0 : list2.pop();
            int sum = x + y + carry; //与进位一起相加
            carry = sum / 10; //更新进位
            //将计算值放入节点
            newNode = new ListNode(sum % 10);
            //更新下一个节点的指向
            newNode.next = head;
            head = newNode;
        }
        return head;

    }
    private static void putData(LinkedList<Integer> s1,ListNode head1) {
        if (s1 == null) s1 = new LinkedList<>();
        //遍历节点将其插入栈中
        while(head1 != null) {
            s1.push(head1.val);
            head1 = head1.next;
        }
    }
}
