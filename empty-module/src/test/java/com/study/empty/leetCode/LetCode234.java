package com.study.empty.leetCode;

import org.junit.Test;

import java.util.List;
import java.util.Stack;

/**
 * @Author： Dingpengfei
 * 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * @Date： 2022/4/2 22:49
 */
public class LetCode234 {

    @Test
    public void test2() {
      ListNode listNode = new ListNode(1);
      ListNode listNode1 = new ListNode(2);
      ListNode listNode2 = new ListNode(1);
      listNode.next =listNode1;
      listNode1.next =listNode2;
        System.out.println(isPalindrome(listNode));

    }

    public boolean isPalindrome(ListNode head) {
        if (head ==null){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while(temp !=null){
            stack.push(temp.val);
            temp= temp.next;
        }
        while(head !=null){
            if (head.val != stack.pop()){
                return false;
            }
            head = head.next;
        }
        return true;
    }

}
