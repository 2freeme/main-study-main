package com.study.empty.leetCode;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import sun.rmi.log.LogInputStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author： Dingpengfei
 * @Description：力扣的前十道题
 * @Date： 2022/2/13 14:09
 */
public class LetCode2 {

    @Test
    public void test() {
        int[] nums = {2, 7, 11, 15};
//        System.out.println(JSONObject.toJSON(addTwoNumbers(nums, 9)));
//        System.out.println(JSONObject.toJSON(twoSum2(nums, 9)));
        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        List<Integer> list = new ArrayList<>();
        getNum(node1, list);
        System.out.println(reserve(list));
        System.out.println(JSONObject.toJSON(list));
        System.out.println(Math.pow(10, 2));
        System.out.println(JSONObject.toJSON(getNodeByInt(1000000)));
        System.out.println(11/10);
    }

    /**
     * 2. 两数相加
     * 将2个node都转化为 int 相加 反转  设成链表
     * 这种暴力的破解的方法容易因为int的限制对于高位数不能破解
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long byNode = getByNode(l1);
        long byNode2 = getByNode(l2);
        long all = byNode + byNode2;

        return null;
    }

    public ListNode getNodeByInt(int all) {
        String[] split = String.valueOf(all).split("");
        ListNode listNode = new ListNode();
        ListNode o = new ListNode();
        for (int i = 0; i < split.length; i++) {
            o = new ListNode(Integer.valueOf(split[i]), i == 0 ? null : listNode);
            listNode = o;
        }
        return o;

    }

    public void getNum(ListNode l1, List a) {
        a.add(l1.val);
        if (l1.next != null) {
            getNum(l1.next, a);
        }
        return;
    }

    public long reserve(List<Integer> a) {
        int size = a.size();
        long b = 0;
        for (int i = size - 1; i >= 0; i--) {
            long pow = (int) Math.pow(10, i) * a.get(i);
            b = b + pow;
        }
        return b;
    }

    public long getByNode(ListNode listNode) {
        List<Integer> list = new ArrayList<>();
        getNum(listNode, list);
        return reserve(list);
    }


    /**
     * 力扣的题解的思路
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int alone = 0;
        ListNode pre = new ListNode(0); //pre的主要作用就是 cur在实时变化的，它做的归集
        ListNode cur = pre;
        while (l1 != null || l2 != null) {
            l1= l1 ==null? new ListNode(0):l1;
            l2= l2 ==null? new ListNode(0):l2; //自动补全
            int sum = l1.val + l2.val + alone;
            alone = sum / 10; //十位数
            int other = sum % 10;     //余数

            ListNode listNode = new ListNode(other);
            cur.next = listNode;
            cur= listNode;
            if (l1!=null){
                l1=l1.next;
            }
            if (l2 !=null){
                l2 = l2.next;
            }
        }
        //到了最后如果还有的话自动加1
        if (alone==1){
            cur.next= new ListNode(alone);
        }
        return pre.next;
    }

}
