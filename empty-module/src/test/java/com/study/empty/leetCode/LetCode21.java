package com.study.empty.leetCode;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Stack;

/**
 * @Author： Dingpengfei
 * @Description：给定一个只包括 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

 */
public class LetCode21 {
    @Test
    public void test2() {
        ListNode q = new ListNode(1);
//        q.next = new ListNode(2);
//        q.next.next = new ListNode(4);

        ListNode a = new ListNode(0);
//        a.next = new ListNode(3);
//        a.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists2(q, a);
        System.out.println(JSONObject.toJSONString(listNode));

    }


    /**
     * 答案递归解法
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 ==null){
            return list1;
        }
        if (list1.val < list2.val){
            list1.next = mergeTwoLists2(list1.next,list2);
            return list1;
        }else{
            list2.next = mergeTwoLists2(list1,list2.next);
            return list2;
        }

    }

        /**
         * 这是自己的方法，核心就是挨个的进行的对比，一个一个的添加上去
         * @param list1
         * @param list2
         * @return
         */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode re = null;
        ListNode temp = null;

        if (list1==null){ //这里是因为l1为空的时候
            list1 =list2;
            list2=null;
        }

        while(list1 !=null){
            int n1 = list1.val;

            while(list2 !=null && list2.val <=n1){
                ListNode listNode = new ListNode(list2.val);
                if (re == null){
                    re = listNode;
                    temp = re;
                }else{
                    temp.next  = listNode;
                    temp = temp.next;
                }
                list2 = list2.next;
            }
            ListNode listNode = new ListNode(list1.val);
            if (re == null){
                re = listNode;
                temp = re;
            }else{
                temp.next = listNode;
                temp = temp.next;
            }
            list1 = list1.next;
        }

        if (list2!=null){ //没结束的就代表着后面的数都比较大
            temp.next =list2;
        }
        return re;

    }
}
