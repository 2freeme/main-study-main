package com.study.empty.leetCode;

/**
 * @Author： Dingpengfei
 * @Description：
 * @Date： 2022/4/1 15:20
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
