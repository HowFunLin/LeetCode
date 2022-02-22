package main.medium;

import java.util.LinkedList;

@SuppressWarnings("unused")
public class DecodeString {
    /**
     * 394. 字符串解码
     *
     * @param s 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次
     * @return 解码后的字符串
     */
    public String decodeString(String s) {
        LinkedList<Integer> stack_multi = new LinkedList<>(); // 乘数栈
        LinkedList<String> stack_res = new LinkedList<>(); // 结果栈
        StringBuilder res = new StringBuilder();

        int multi = 0;

        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString()); // 存储中间结果

                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();

                for (int i = 0; i < cur_multi; i++)
                    tmp.append(res);

                res = new StringBuilder(stack_res.removeLast()).append(tmp);
            } else if (c >= '0' && c <= '9') // 数字一定是连续乘数，因此可以按此区分
                multi = multi * 10 + c - '0';
            else
                res.append(c);
        }

        return res.toString();
    }
}
