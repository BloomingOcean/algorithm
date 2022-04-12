package 牛客面试必刷TOP101.链表;

/**
 * @Author Li Yang
 * @Date 22/04/12 11:24
 * @Version 1.0
 */
public class BM7_链表中环的入口结点 {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 快慢指针（快指针走慢指针的两倍速度）（不同于BM6）
     * 经过题目描述可得知以下信息：
     * 假设头节点到入口节点之间的距离是X，如果入口结点到相遇结点之间的距离是Y，
     * 相遇节点（顺时针）到入口结点的距离是Z，慢指针走过的距离为A，快指针走过的距离为2A
     * 那么可以有以下等式：
     * X + 2Y + Z = 2A
     * X+Y = A
     * 则可得出 Z = A
     * 那么慢指针从相遇结点走到入口结点（顺时针）的距离恰好是快指针从头节点走到入口结点的距离
     * @param pHead 头
     * @return 入口结点
     */
    public ListNode EntryNodeOfLoopHashFastSlow(ListNode pHead) {
        ListNode slow = pHead;
        ListNode fast = pHead;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        // 若是快指针指向null，则不存在环(囊括了“没有结点”“只有一个结点”的情况)
        if(fast == null || fast.next == null) return null;

        // 重新指向链表头部
        fast = pHead;

        // 与第一次相遇的结点相同速度出发，相遇结点为入口结点
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    /**
     * hash表（和BM6的hash方法一致）
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoopHash(ListNode pHead) {
        return null;
    }
}
