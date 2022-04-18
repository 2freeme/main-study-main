package com.study.empty.leetCode.middle;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author： Dingpengfei
 * @Description：括号生成 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 */
public class LetCode22 {

    @Test
    public void test() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(generateParenthesis(4));

    }

    public List<String> generateParenthesis(int n) {

        //其实对于括号来说 第一个和 最后一个的括号总是确定的，长度为 2n

        List<List<String>> res = new LinkedList<>();
        res.add(new LinkedList<>(Arrays.asList("")));
        res.add(new LinkedList<>(Arrays.asList("()")));
        for (int i = 2; i <= n; i++) {
            List<String> tmp = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = res.get(j);
                List<String> str2 = res.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        String str = "(" + s1 + ")" + s2;
                        tmp.add(str);
                    }
                }
            }
            res.add(tmp);
        }
        return res.get(n);
    }
}

