package 牛客面试必刷TOP101.链表;

/**
 * @Author Li Yang
 * @Date 22/04/09 16:30
 * @Version 1.0
 */
public class BM4_合并两个排序链表 {
    /**
     * 输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
     * 数据范围： 0 ≤ n ≤ 1000，−1000 ≤ 节点值 ≤ 1000
     * 要求：空间复杂度 O(1)，时间复杂度 O(n)
     *
     * 如输入{1,3,5},{2,4,6}时，合并后的链表为{1,2,3,4,5,6}，所以对应的输出为{1,2,3,4,5,6}
     */
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(8);
        n1.next = n2;
        n2.next = n3;

        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(9);
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        System.out.println(n1.toString());
        System.out.println("合并之后：\n" + Merge(n1, n4).toString());
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
     * 递归用法（注意基准条件和递归条件的判定）
     * @param list1 1
     * @param list2 2
     * @return 合并
     */
    public static ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null){
            return list2;
        } else if(list2 == null){
            return list1;
        }

        //
        if(list2.val > list1.val){
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }
}
