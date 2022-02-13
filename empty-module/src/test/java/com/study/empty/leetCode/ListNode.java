package com.study.empty.leetCode;

import lombok.Data;
import lombok.ToString;

/**
 * @Author： Dingpengfei
 * @Description：
 * @Date： 2022/2/13 15:02
 */
@Data
@ToString
public class ListNode {
    Integer val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
