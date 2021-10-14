package company;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

@SuppressWarnings("unused")
public class Qunar {
    /**
     * 合并两个有序数组为一个有序数组
     *
     * @param a 数组 a
     * @param m 数组 a 有效元素个数
     * @param b 数组 b
     * @param n 数组 b 有效元素个数
     * @return 合并后的有序数组
     */
    public int[] mergeSortedArray(int[] a, int m, int[] b, int n) {
        int[] res = new int[m + n];
        int pa = 0, pb = 0, index = 0;

        while (pa != m && pb != n) {
            if (a[pa] < b[pb]) {
                res[index] = a[pa];
                pa++;
            } else if (a[pa] > b[pb]) {
                res[index] = b[pb];
                pb++;
            } else {
                res[index++] = a[pa];
                res[index] = b[pb];
                pa++;
                pb++;
            }

            index++;
        }

        if (pa == m)
            for (int i = pb; i < n; i++)
                res[index++] = b[i];
        else
            for (int i = pa; i < m; i++)
                res[index++] = a[i];

        return res;
    }

    /**
     * <h3>格式化字符串</h3>
     * <div>1. 按出现频率排序；</div>
     * <div>2. 出现频率相同，按大写字母个数排序；</div>
     * <div>3. 出现频率和大写字母个数都相同，按字母表顺序排序</div>
     * <p></p>
     * 例如：aaBba --> aaaBb
     * <p></p>
     * 用例通过率：83%
     *
     * @param s 原字符串
     * @return 格式化后的字符串
     */
    public String formatString(String s) {
        int[] appearance = new int[26], upper = new int[26];

        char[] chars = s.toCharArray();

        for (char cur : chars) {
            if (cur <= 'Z') {
                appearance[cur - 'A']++;
                upper[cur - 'A']++;
            }

            if (cur >= 'a')
                appearance[cur - 'a']++;
        }

        PriorityQueue<Character> heap = new PriorityQueue<>(((o1, o2) -> {
            if (appearance[o2 - 'a'] == appearance[o1 - 'a']) {
                if (upper[o2 - 'a'] == upper[o1 - 'a'])
                    return o1 - o2;
                else
                    return upper[o2 - 'a'] - upper[o1 - 'a'];
            }

            return appearance[o2 - 'a'] - appearance[o1 - 'a'];
        }));

        for (int i = 'a'; i <= 'z'; i++) {
            if (appearance[i - 'a'] != 0)
                heap.add((char) i);
        }

        StringBuilder builder = new StringBuilder();

        while (!heap.isEmpty()) {
            char c = heap.poll();

            for (int i = 0; i < upper[c - 'a']; i++)
                builder.append((char) (c - 'a' + 'A'));

            for (int i = 0; i < appearance[c - 'a'] - upper[c - 'a']; i++)
                builder.append(c);
        }

        return builder.toString();
    }

    /**
     * <h3>计算LISP表达式</h3>
     * 例如：(* (+ 1 2) (/ 2 1)) --> ((1 + 2) * (2 / 1))； / ， - 运算最多只允许有两个参数
     * <p></p>
     * 用例通过率：64%
     *
     * @param s LISP表达式
     * @return 计算结果
     */
    public int calculate(String s) {
        char[] array = s.toCharArray();

        Stack<Integer> stack = new Stack<>();
        Stack<Character> br = new Stack<>();
        Stack<Character> operator = new Stack<>();

        Set<Character> set = new HashSet<>();
        set.add('+');
        set.add('-');
        set.add('*');
        set.add('/');

        boolean isValidSubtract = true, isValidDivision = true;

        for (char c : array) {
            if (c == ' ')
                continue;

            if (c == '(') {
                br.push(c);
                stack.push(Integer.MIN_VALUE);
            }

            if (set.contains(c))
                operator.push(c);

            if (c == ')') {
                if (br.isEmpty() || br.pop() != '(') {
                    System.out.println("invalid expression");
                    System.exit(0);
                }

                operator.pop();

                Integer temp = stack.pop();

                if (stack.pop() != Integer.MIN_VALUE) {
                    System.out.println("invalid expression");
                    System.exit(0);
                }

                stack.push(temp);

                isValidDivision = true;
                isValidSubtract = true;
            }

            if (operator.isEmpty() || !set.contains(operator.peek())) {
                System.out.println("invalid expression");
                System.exit(0);
            }

            if (stack.peek() == Integer.MIN_VALUE)
                stack.push(c - '0');
            else {
                if (c < '0' || c > '9') {
                    System.out.println("invalid expression");
                    System.exit(0);
                }

                int top = stack.pop() - '0';

                if (operator.peek() == '+')
                    stack.push(top + c - '0');

                if (operator.peek() == '-') {
                    if (!isValidSubtract) {
                        System.out.println("invalid expression");
                        System.exit(0);
                    }

                    stack.push(top - c - '0');
                    isValidSubtract = false;
                }

                if (operator.peek() == '*')
                    stack.push(top * (c - '0'));

                if (operator.peek() == '/') {
                    if (!isValidDivision) {
                        System.out.println("invalid expression");
                        System.exit(0);
                    }

                    stack.push(top / (c - '0'));
                    isValidDivision = false;
                }
            }
        }

        return stack.pop();
    }
}
