package com.study.empty.leetCode;

import java.util.Stack;

/**
 * @Author： Dingpengfei
 * @Description：设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * 实现 MinStack 类:
 * <p>
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 * <p>
 * 链接：https://leetcode-cn.com/problems/min-stack
 * @Date： 2022/4/1 22:24
 */
public class LetCode155 {


    class MinStack {

        Stack<Integer> data;
        Stack<Integer> helper;


        public MinStack() {
            data = new Stack<>();
            helper = new Stack<>();
        }

        public void push(int val) {
            data.push(val);
            if (helper.empty() || val <= helper.peek())
                helper.push(val);

        }

        public void pop() {
            data.pop();
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return helper.peek();
        }
    }
}
