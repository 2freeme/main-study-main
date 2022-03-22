package com.study.empty.leetCode;

import org.junit.Test;

/**
 * @Author： Dingpengfei
 * @Description：你是产品经理，目前正在带领一个团队开发新的产品 。不幸的是，你的产品的最新版本没有通过质量检测
 * 。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * <p>
 * 你可以通过调用 bool isBadVersion(version)
 *  接口来判断版本号 version 是否在单元测试中出错。
 * 实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * @Date： 2022/3/9 13:56
 */
public class LetCode274 {

    @Test
    public void test2() {
        int i = firstBadVersion(2);
        System.out.println(i);
    }

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid+1;//正好过滤边界值
            }
        }
        return start;
    }

    boolean isBadVersion(int version) {
        return version >= 2;
    }

}

