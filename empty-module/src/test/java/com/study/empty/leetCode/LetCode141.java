package com.study.empty.leetCode;

import java.util.*;

/**
 * @Author： Dingpengfei
 * @Description：给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * @Date： 2022/4/1 17:14
 */
public class LetCode141 {

    public void test2() {
        Stack<String> strings = new Stack<>();
        String i = "){";
        int[] nums = {7, 1, 5, 3, 6, 4};
//        System.out.println(hasCycle(nums));
    }

    public boolean hasCycle(ListNode head) {

        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            if (list.contains(head)) {
                return true;
            }
            list.add(head);
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
