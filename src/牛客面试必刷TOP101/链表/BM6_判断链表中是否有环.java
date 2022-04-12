package 牛客面试必刷TOP101.链表;

import java.util.HashSet;

/**
 * @Author Li Yang
 * @Date 22/04/12 10:53
 * @Version 1.0
 */
public class BM6_判断链表中是否有环 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
//        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        System.out.println("是否有环：\n" + hasCycleFastSlow(n1));
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 快慢指针优化
     * @param head 头
     * @return 入口节点
     */
    public static boolean hasCycleFastSlowOptimization(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    /**
     * 快慢指针
     * @param head 头
     * @return 判断
     */
    public static boolean hasCycleFastSlow(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        if(head == null) {
            return false;
        }
        while(true) {
            // 慢指针走一步
            slow = slow.next;

            // 快指针走两步
            if(fast != null){
                fast = fast.next;
            } else {
              break;
            }

            if(fast != null){
                fast = fast.next;
            } else {
                break;
            }
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    /**
     * hash表
     * @param head 头
     * @return 判断
     */
    public static boolean hasCycleHash(ListNode head) {
        if(head == null) {
            return false;
        }
        HashSet set = new HashSet();
        set.add(head);
        while(true) {
            if(head == null || head.next == null){
                return false;
            }
            head = head.next;
            if(!set.contains(head)){
                set.add(head);
            } else {
                return true;
            }
        }
    }
}
