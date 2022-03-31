package company;

import struct.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

@SuppressWarnings("unused")
public class HuaWei {
    private static List<Integer> temp = new LinkedList<>();
    private int min = Integer.MAX_VALUE;
    private int lines = 0;
    private boolean[][] visited;

    public void configuringChipsBusiness() {
        Scanner scanner = new Scanner(System.in);

        // 芯片个数，每个芯片容量 10 G，只支持单一业务
        int chipNum = scanner.nextInt();

        // 业务个数和业务数组，A 业务占用 2.5G，B 业务占用 10G
        int businessNum = scanner.nextInt();
        String[] businesses = new String[businessNum];

        for (int i = 0; i < businessNum; i++)
            businesses[i] = scanner.next();

        // 空芯片的编号（从 1 开始），仍有空间容纳 A 业务的芯片位置，资源 ID
        int empty = 1, emptyA = 0, resourceId = 0;

        for (int i = 0; i < businessNum; i++) {
            if (businesses[i].equals("B"))
                empty++;
            else {
                // 表示尚未存在容纳 A 业务的芯片 或 当前容纳 A 业务的芯片已满
                if (emptyA == 0 || resourceId == 4) {
                    emptyA = empty;
                    empty++;
                    resourceId = 1;
                } else
                    resourceId++;
            }
        }

        // 需要的芯片数已超过拥有的芯片数
        if (empty > chipNum + 1) {
            System.out.println(0);
            System.out.println(0);
        } else {
            if (businesses[businessNum - 1].equals("A")) {
                System.out.println(emptyA);
                System.out.println(resourceId);
            } else {
                System.out.println(empty - 1);
                System.out.println(1);
            }
        }
    }

    public void shortestPathToReachTheEnd() {
        Scanner scanner = new Scanner(System.in);

        // 地图大小 m x n，起点(startRow, startEnd)，终点(endRow, endCol)
        int m = scanner.nextInt(), n = scanner.nextInt();
        int startRow = scanner.nextInt(), startCol = scanner.nextInt();
        int endRow = scanner.nextInt(), endCol = scanner.nextInt();

        int[][] map = new int[m][n];
        visited = new boolean[m][n]; // 记录当前路径访问过的位置

        // 湖泊的数量和坐标
        int lakes = scanner.nextInt();

        for (int i = 0; i < lakes; i++) {
            int x = scanner.nextInt(), y = scanner.nextInt();

            map[x][y] = 1;
        }

        dfs(map, startRow, startCol, endRow, endCol, 0);

        System.out.println(lines + " " + min);
    }

    private void dfs(int[][] map, int row, int col, int endRow, int endCol, int cur) {
        // 剪枝
        if (row < 0 || row >= map.length || col < 0 || col >= map[0].length || map[row][col] == 1 || visited[row][col] || cur > min)
            return;

        // 到达终点返回
        if (row == endRow && col == endCol) {
            if (cur < min) {
                min = cur;
                lines = 1;
            } else if (cur == min)
                lines++;

            return;
        }

        visited[row][col] = true;

        dfs(map, row + 1, col, endRow, endCol, cur + 1);
        dfs(map, row - 1, col, endRow, endCol, cur + 1);
        dfs(map, row, col + 1, endRow, endCol, cur + 1);
        dfs(map, row, col - 1, endRow, endCol, cur + 1);

        visited[row][col] = false; // 退出回溯（重要）
    }

    /**
     * 用例通过率：25%
     * 改进思路：得到所有子树的字符串形式并取出存在相同字符串的最长字符串
     */
    public void deepestSubTree() {
        Scanner scanner = new Scanner(System.in);

        String origin = scanner.nextLine();
        String s = origin.substring(1, origin.length() - 1);

        String[] treeNodes = s.split(",");

        // 构造二叉树
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(treeNodes[0]));

        int index = 1;
        queue.add(root);

        while (index < treeNodes.length) {
            TreeNode node = queue.poll();

            // null 节点值设置为 -1
            if (index < treeNodes.length) {
                TreeNode left;

                if (!treeNodes[index].equals("null"))
                    left = new TreeNode(Integer.valueOf(treeNodes[index]));
                else
                    left = new TreeNode(-1);

                node.left = left;
                queue.offer(left);

                index++;
            }

            if (index < treeNodes.length) {
                TreeNode right;

                if (!treeNodes[index].equals("null"))
                    right = new TreeNode(Integer.valueOf(treeNodes[index]));
                else
                    right = new TreeNode(-1);

                node.right = right;
                queue.offer(right);

                index++;
            }
        }

        traverse(root);

        if (temp.size() == 0)
            System.out.println("-1");
        else {
            StringBuilder sb = new StringBuilder();

            sb.append('[');

            for (Integer integer : temp) {
                sb.append(integer == -1 ? "null" : integer).append(',');
            }

            sb.deleteCharAt(sb.length() - 1);
            sb.append(']');

            System.out.println(sb.toString());
        }
    }

    private void traverse(TreeNode node) {
        if (node == null || node.val == -1)
            return;

        // 思路出错：不能只比较某个节点的左右子树
        if (isSameTree(node.left, node.right)) {
            if (node.left != null) {
                List<Integer> tmp = new LinkedList<>();
                Queue<TreeNode> queue = new LinkedList<>();
                queue.offer(node.left);

                while (!queue.isEmpty()) {
                    TreeNode poll = queue.poll();
                    tmp.add(poll.val);

                    if (poll.left != null)
                        queue.offer(poll.left);
                    if (poll.right != null)
                        queue.offer(poll.right);
                }

                if (tmp.size() > 1 && tmp.size() > temp.size())
                    temp = new LinkedList<>(temp);
            }
        }

        traverse(node.left);
        traverse(node.right);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if ((p == null && q != null) || (p != null && q == null) || (p.val != q.val))
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
