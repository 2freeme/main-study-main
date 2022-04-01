package com.study.empty.leetCode;

/**
 * @Author： Dingpengfei
 * @Description：给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * @Date： 2022/4/2 0:07
 */
public class LetCode160 {

    /**
     * 最优方法中最合适 2次遍历，因为最终要找到交点，则把他们拼成一样的即可。按照位数进行对比。
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null && headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;

    }
}
