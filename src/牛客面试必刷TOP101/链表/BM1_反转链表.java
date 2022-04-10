package 牛客面试必刷TOP101.链表;

/**
 * @Author Li Yang
 * @Date 22/04/09 10:52
 * @Version 1.0
 */
public class BM1_反转链表 {

    /**
     * 给定一个单链表的头结点pHead(该头节点是有值的，比如在下图，它的val是1)，长度为n，
     * 反转该链表后，返回新链表的表头。
     *
     * 数据范围： 0≤n≤1000
     * 要求：空间复杂度 O(1)，时间复杂度 O(n)
     *
     * 如当输入链表{1,2,3}时，
     * 经反转后，原链表变为{3,2,1}，所以对应的输出为{3,2,1}。
     */
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(n1.toString());
        System.out.println("反转之后：\n" + ReverseList(n1).toString());
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    /**
     * 反转
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param head 头
     * @return 反转头
     */
    public static ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while(cur != null){
            /**
             * 这里需要注意：为避免在边界时cur为null时的空指针异常
             * 需要把after指针的更新放在下一轮遍历的开头，而不是和pre和cur一样放在结尾
             */
            ListNode after = cur.next;
            cur.next = pre;

            pre = cur;
            cur = after;
        }
        return pre;
    }
}
