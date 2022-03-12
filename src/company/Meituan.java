package company;

import java.util.*;

@SuppressWarnings("unused")
public class Meituan {
    private static int max = Integer.MIN_VALUE;
    private static int[] table;

    public void isLuckyNumber() {
        Scanner scanner = new Scanner(System.in);

        Integer n = Integer.valueOf(scanner.nextLine()); // 需要判断的数字个数

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine()); // 获取需要判断的数字

            if (num % 11 == 0) { // 若为 11 的倍数即为幸运数
                System.out.println("yes");
                continue;
            }

            int ones = 0;

            while (num > 0) {
                if ((num % 10) == 1)
                    ones++;

                num /= 10;
            }

            if (ones >= 2) // 十进制下，有两位为 1 即为幸运数
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }

    public void numberOfSubSequencesWhichProductIsPositive() {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.valueOf(scanner.nextLine()); // 数组的数字个数

        int[] nums = new int[n + 1];

        String[] arrStr = scanner.nextLine().split(" ");

        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.valueOf(arrStr[i - 1]); // 构建数组
        }

        int sum = 0;

        // 构建前缀和记录出现过的 -1 的个数，前置 0 用于后续判断从 第 1 个数到第 n 个数的 -1 个数
        for (int i = 1; i <= n; i++) {
            if (nums[i] == -1)
                sum++;

            nums[i] = sum;
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (((nums[j] - nums[i]) & 1) == 0) // 位运算判断是否为 2 的倍数更快
                    res++;
            }
        }

        System.out.println(res);
    }

    /**
     * 测试用例通过率：81%
     */
    public void maxConsumersCouldSatisfy() {
        Scanner scanner = new Scanner(System.in);

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.valueOf(nm[0]), m = Integer.valueOf(nm[1]); // 1 ~ m 种菜，每样菜只有一份

        int[][] orders = new int[n][2]; // n 个 顾客，每个顾客点两样菜

        for (int i = 0; i < n; i++) {
            String[] strOrders = scanner.nextLine().split(" ");

            orders[i][0] = Integer.valueOf(strOrders[0]);
            orders[i][1] = Integer.valueOf(strOrders[1]);
        }

        table = new int[m + 1];

        backtrack(orders, 0, 0);

        System.out.println(max); // 尽可能使最多位顾客满意
    }

    private void backtrack(int[][] orders, int index, int satisfy) {
        if (index == orders.length || (table[orders[index][0]] >= 1 || table[orders[index][1]] >= 1)) {
            max = Math.max(max, satisfy);
            return;
        }

        int order0 = orders[index][0], order1 = orders[index][1];

        table[order0]++;
        table[order1]++;

        for (int i = index + 1; i <= orders.length; i++) {
            backtrack(orders, i, satisfy + 1);
        }

        table[order0]--;
        table[order1]--;
    }

    public void bombsGame() {
        Scanner scanner = new Scanner(System.in);

        String[] nm = scanner.nextLine().split(" ");
        int n = Integer.valueOf(nm[0]), m = Integer.valueOf(nm[1]); // n 个房子

        int[] bombs = new int[m]; // m 个单位时间，bombs[i] 为时间 i 炸弹所在的房子

        String[] bombsStr = scanner.nextLine().split(" ");

        for (int i = 0; i < m; i++) {
            bombs[i] = Integer.valueOf(bombsStr[i]);
        }

        Set<Integer> set = new HashSet<>();
        int res = 0, index = -1;

        for (int i = 0; i < bombs.length; i++) { // 初始所在的房间号为 1，初始化到下一个位置
            if (bombs[i] == 1) {
                res++;
                index = i;
                break;
            }
        }

        for (int i = index; i < bombs.length; i++) {
            set.add(bombs[i]); // 贪心

            if (set.size() == n) { // 所有数字已经加入集合，必须更换房间
                res++;
                set.clear();
                set.add(bombs[i]);
            }
        }

        System.out.println(res);
    }

    public void blackWhiteTree() {
        Scanner scanner = new Scanner(System.in);

        Integer n = Integer.valueOf(scanner.nextLine());

        int[] color = new int[n + 1];

        String[] s = scanner.nextLine().split(" ");

        for (int i = 1; i <= n; i++) {
            color[i] = Integer.valueOf(s[i - 1]);
        }

        int[] parents = new int[n + 1];

        String[] ss = scanner.nextLine().split(" ");

        for (int i = 1; i <= n; i++) {
            parents[i] = Integer.valueOf(ss[i - 1]);
        }

        // 构建多叉树，节点从 1 开始，数组从 1 开始方便计算
        List<List<Integer>> children = new ArrayList<>(n + 1);

        for (int i = 0; i <= n; i++) {
            children.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            if (parents[i] != 0) {
                children.get(parents[i]).add(i);
            }
        }

        int white = 0, black = 0;

        for (int i = 1; i <= n; i++) {
            int cur = color[i];

            if (cur == 0) { // 白色“好节点”的条件：无子节点 || 至少有一个黑色节点
                if (children.get(i).size() == 0)
                    white++;

                for (Integer integer : children.get(i)) {
                    if (color[integer] == 1) {
                        white++;
                        break;
                    }
                }
            } else { // 黑色“好节点”的条件：无子节点 || 子节点均为白色节点
                if (children.get(i).size() == 0) {
                    black++;
                    continue; // 避免重复计算
                }

                int whiteChild = 0;

                for (Integer integer : children.get(i)) {
                    if (color[integer] == 0) {
                        whiteChild++;
                    }
                }

                if (whiteChild == children.get(i).size())
                    black++;
            }
        }

        System.out.println(white + " " + black);
    }
}
