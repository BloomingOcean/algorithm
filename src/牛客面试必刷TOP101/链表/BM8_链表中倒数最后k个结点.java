package 牛客面试必刷TOP101.链表;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @Author Li Yang
 * @Date 22/04/12 15:34
 * @Version 1.0
 */
public class BM8_链表中倒数最后k个结点 {

    public static void main(String[] args) {

    }

    public static class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 双指针
     * @param pHead 头
     * @param k 倒数k个
     * @return 倒数第k个结点
     */
    public static ListNode FindKthToTailDoublePoint (ListNode pHead, int k) {
        // write code here
        ListNode first = pHead;
        ListNode afterK = pHead;
        for (int i = 0; i < k; i++) {
            if(afterK == null){
                return null;
            }
            afterK = afterK.next;
        }

        while(afterK != null) {
            first = first.next;
            afterK = afterK.next;
        }
        return first;
    }

    /**
     * 栈
     * @param pHead 头
     * @param k 倒数k个
     * @return 倒数第k个结点
     */
    public static ListNode FindKthToTailStack (ListNode pHead, int k) {
        Deque<ListNode> stack = new ArrayDeque<>();
        int count = 0;
        while(pHead != null) {
            stack.push(pHead);
            pHead = pHead.next;
            count++;
        }

        // 包含了链表结点为空和长度不够k的情况
        if(k == 0 || count < k){
            return null;
        }

        ListNode firstNode = stack.pop();
        while(--k > 0) {
            ListNode temp = stack.pop();
            temp.next = firstNode;
            firstNode = temp;
        }
        return firstNode;
    }

    /**
     * 递归（触底反弹）（也可以用于 -》 逆向打印链表）
     * @param pHead 头
     * @param k 倒数k个
     * @return 倒数第k个结点
     */
    static int size=0;

    public static ListNode FindKthToTailRecursion (ListNode pHead, int k) {
        if(pHead == null){
            return null;
        }
        ListNode node = FindKthToTailRecursion(pHead, k-1);
        ++size;
        //从后面数结点数小于k，返回空
        if (size < k) {
            return null;
        } else if (size == k) {
            //从后面数访问结点等于k，直接返回传递的结点k即可
            return pHead;
        } else {
            //从后面数访问的结点大于k，说明我们已经找到了，
            //直接返回node即可
            return node;
        }
    }
}
