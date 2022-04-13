package 牛客面试必刷TOP101.链表;

/**
 * @Author Li Yang
 * @Date 22/04/13 10:25
 * @Version 1.0
 */
public class BM9_删除链表的倒数第n个节点 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
        System.out.println("移除结点后链表：\n" + removeNthFromEnd(n1,2));
    }

    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }

    /**
     * 双指针
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        //fast移n步，
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        //如果fast为空，表示删除的是头结点
        if (fast == null)
            return head.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //这里最终slow不是倒数第n个节点，他是倒数第n+1个节点，
        //他的下一个结点是倒数第n个节点,所以删除的是他的下一个结点
        slow.next = slow.next.next;
        return head;

    }
}
