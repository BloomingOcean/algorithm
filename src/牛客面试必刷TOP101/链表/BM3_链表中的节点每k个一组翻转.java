package 牛客面试必刷TOP101.链表;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @Author Li Yang
 * @Date 22/04/09 14:57
 * @Version 1.0
 */
public class BM3_链表中的节点每k个一组翻转 {
    /**
     * 将给出的链表中的节点每 k 个一组翻转，返回翻转后的链表
     * 如果链表中的节点数不是 k 的倍数，将最后剩下的节点保持原样
     * 你不能更改节点中的值，只能更改节点本身。
     *
     * 例如：
     * 给定的链表是 1 → 2 → 3 → 4 → 5
     * 对于 k = 2, 你应该返回 2 → 1 → 4 → 3 → 5
     * 对于 k = 3, 你应该返回 3 → 2 → 1 → 4 → 5
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
        System.out.println("反转之后：\n" + reverseKGroup(n1,2).toString());
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
     * 翻转的经典用法: 栈
     * @param head 头
     * @param k 翻转个数
     * @return 翻转结果
     */
    public static ListNode reverseKGroup (ListNode head, int k) {
        if(k <= 1 || head == null) return head;
        //模拟栈
        Deque<ListNode> st = new ArrayDeque<ListNode>();
        ListNode result = new ListNode(0);
        ListNode now = result;
        int cnt = 0;
        while(true){
            //将当前链表前k个存入栈中
            for(int i = 0; i < k; i ++){
                st.push(head);
                head = head.next;
                cnt ++;
                if(head == null) break;
            }
            //如果当前栈中有k个元素则一一取出存入链表
            if(cnt == k){
                while(!st.isEmpty()){
                    now.next = st.pop();
                    now = now.next; now.next = null;
                }
            }
            //如果链表取完了跳出循环
            if(head == null) break;
            cnt = 0;
        }
        ListNode end = null;
        //如果栈中还有剩下的就说明是最后的一块直接取栈底即可
        while(!st.isEmpty()){
            end = st.pop();
        }
        now.next = end;
        return result.next;
    }
}
