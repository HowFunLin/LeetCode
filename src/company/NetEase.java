package company;

import java.util.*;

@SuppressWarnings("unused")
public class NetEase {
    /**
     * 通过率：96%
     */
    public void allSameHappiness() {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt(), k = scanner.nextInt();
        int[] happiness = new int[m]; // m 件物品对应的快乐度

        for (int i = 0; i < m; i++)
            happiness[i] = scanner.nextInt();

        int sum = 0;

        for (int i = 0; i < m; i++)
            sum += happiness[i];

        if (sum % k != 0)
            System.out.println("False");
        else
            System.out.println("True");

        // TODO 0-1 背包
        // 必须满足通过分发 m 件物品使得 k 个人获得的快乐度均相同
    }

    /**
     * 带括号的加减乘除四则运算
     * <p>
     * 通过率：58.82%
     */
    public void arithmetic() {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Deque<Integer> nums = new LinkedList<>();
        Deque<Character> opts = new LinkedList<>();

        int temp = 0;
        char preOpt = '+';

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            // Shit...
            if (Character.isDigit(c)) {
                temp = temp * 10 + c - '0';

                if (i == input.length() - 1) {
                    if (preOpt == '*') {
                        nums.push(nums.pop() * temp);
                    } else if (preOpt == '/') {
                        nums.push(nums.pop() / temp);
                    } else if (preOpt == '+' || preOpt == '-') {
                        nums.push(temp);
                        opts.push(preOpt);
                    }
                }
            } else {
                if (preOpt == '*') {
                    nums.push(nums.pop() * temp);
                } else if (preOpt == '/') {
                    nums.push(nums.pop() / temp);
                } else if (preOpt == '+' || preOpt == '-') {
                    nums.push(temp);
                    opts.push(preOpt);
                }

                if (i < input.length() && input.charAt(i + 1) == '(' && (c != '*' || c != '/'))
                    opts.push(c);

                if (c != '(' && c != ')')
                    preOpt = c;

                if (c == '(')
                    opts.push(c);

                if (c == ')') {
                    int top = 0;

                    while (opts.peek() != '(') {
                        if (opts.pop() == '+')
                            top += nums.pop();
                        else
                            top -= nums.pop();
                    }

                    nums.push(top);

                    opts.pop();
                }

                temp = 0;
            }
        }

        int res = 0;

        while (!nums.isEmpty()) {
            if (opts.pop() == '+')
                res += nums.pop();
            else
                res -= nums.pop();
        }

        System.out.println(res);
    }

    /**
     * 叠加矩阵平方，结果矩阵 S = 矩阵 A 的 1 次方 + 2 次方 + ... + k 次方
     */
    public void matrixMultiply() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), k = scanner.nextInt(), m = scanner.nextInt();

        int[][] a = new int[n][n]; // 矩阵 A

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        int[][] temp = new int[n][n]; // 缓存 A 的次方

        for (int i = 0; i < n; i++) {
            System.arraycopy(a[i], 0, temp[i], 0, n);
        }

        int[][] res = new int[n][n];

        for (int i = 0; i < n; i++) {
            System.arraycopy(a[i], 0, res[i], 0, n);
        }

        for (int times = 1; times < k; times++) {
            int[][] tmp = new int[n][n]; // 临时表，防止计算得到的新值影响后续计算

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int sum = 0;

                    for (int row = 0, col = 0; row < n; row++, col++) {
                        sum += (temp[i][col] * a[row][j]) % m;
                    }

                    tmp[i][j] = sum % m;
                    res[i][j] += sum % m;
                    res[i][j] %= m;
                }
            }

            temp = tmp;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print((res[i][j] % m) + " ");
            }

            System.out.println(res[i][n - 1] % m);
        }
    }

    /**
     * 利用 1 ~ 9 之间的数构造满足 [][] x [][] = [][] x [][][] 的式子
     * <p>
     * 通过率：100%
     */
    class Multiply {
        private List<Integer> multi = new ArrayList<>();
        private Set<Integer> multiRes = new HashSet<>();
        private List<String> res = new LinkedList<>();

        public void output() {
            backtrack();

            for (String formula : res)
                System.out.println(formula);
        }

        private void backtrack() {
            if (multi.size() == 9) {
                int a = multi.get(0) * 10 + multi.get(1);
                int b = multi.get(2) * 10 + multi.get(3);

                int c = multi.get(4) * 10 + multi.get(5);
                int d = multi.get(6) * 100 + multi.get(7) * 10 + multi.get(8);

                if (!multiRes.contains(a * b) && a * b == c * d) {
                    res.add(a + " x " + b + " = " + c + " x " + d);
                    multiRes.add(a * b); // 记录当前乘积，后续出现相等则排除

                    return;
                }
            }

            for (int i = 1; i <= 9; i++) {
                // 数字彼此唯一，由于数量小，可直接用 List
                if (!multi.contains(i)) {
                    multi.add(i);

                    backtrack();

                    multi.remove(multi.size() - 1);
                }
            }
        }
    }
}
