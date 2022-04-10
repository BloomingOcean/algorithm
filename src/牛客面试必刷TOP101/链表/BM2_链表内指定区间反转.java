package 牛客面试必刷TOP101.链表;

/**
 * @Author Li Yang
 * @Date 22/04/09 11:11
 * @Version 1.0
 */
public class BM2_链表内指定区间反转 {
    /**
     * 将一个节点数为 size 的链表 m 位置到 n 位置之间的区间反转，
     * 要求时间复杂度 O(n)，空间复杂度 O(1)
     * 例如：
     * 给出的链表为 1 -> 2 -> 3 -> 4 -> 5 -> NULL, m=2,n=4
     * 返回 1 -> 4 -> 3 -> 2 -> 5 -> NULL
     *
     * 数据范围：
     * 链表长度 0 < size ≤ 1000，0 < m ≤ n ≤ size，
     * 链表中每个节点的值满足 |val| ≤ 1000
     */
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
//        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
//        n5.next = n6;
        System.out.println(n1.toString());
        System.out.println("反转之后：\n" + reverseBetween(n1,2,4).toString());
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val){
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
     *
     * 每遍历到一个节点，让这个新节点来到反转部分的起始位置
     * cur：指向待反转区域的第一个节点 left；
     * Cur_next：永远指向 curr 的下一个节点，循环过程中，curr 变化以后 Cur_next 会变化；
     * pre：永远指向待反转区域的第一个节点 left 的前一个节点，在循环过程中不变。
     *
     * @param head 头
     * @param m left
     * @param n right
     * @return 反转后
     */
    public static ListNode reverseBetween (ListNode head, int m, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        // 4个指针，分别指向“第m的前一个节点” “第m节点” “第n节点” ”第n节点的后一个节点“

        // 永远指向待反转区域的第一个节点 left 的前一个节点，在循环过程中不变
        ListNode pre = dummyNode;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }

        // 指向待反转区域的第一个节点 left
        ListNode cur = pre.next;
        // 永远指向 cur 的下一个节点，循环过程中，cur 变化以后 Cur_next 会变化
        ListNode Cur_next = null;

        for (int i = 0; i < n-m; i++) {
            //
            Cur_next = cur.next;

            //
            cur.next = Cur_next.next;
            Cur_next.next = pre.next;
            pre.next = Cur_next;
        }
        return dummyNode.next;
    }
}
