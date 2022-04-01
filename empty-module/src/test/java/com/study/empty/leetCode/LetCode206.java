package com.study.empty.leetCode;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author： Dingpengfei
 * @Description：
 * @Date： 2022/4/1 23:24
 */
public class LetCode206 {

    @Test
    public void test2() {


    }

    /**
     * 单调栈 简单的一笔
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while(head !=null){
            stack.push(head);
            head = head.next;
        }
        ListNode newNode = null;
        while (!stack.empty()){
            ListNode pop = stack.pop();

            pop.next =null;
            if (newNode ==null){
                newNode = pop;
            }else{
                newNode.next= pop;
            }
        }
        return newNode;
    }
}
