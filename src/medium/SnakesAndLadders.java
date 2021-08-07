package medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] nums = new int[n * n + 1];

        int index = 0;
        for (int row = n - 1, num = 0; row >= 0; row--, num++) {
            if (num % 2 == 0)
                for (int col = 0; col < n; col++)
                    nums[++index] = board[row][col];
            else
                for (int col = n - 1; col >= 0; col--)
                    nums[++index] = board[row][col];
        }

        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        int res = 0;

        while (!queue.isEmpty())
        {
            int size = queue.size();

            for (int i = 0; i < size; i++)
            {
                int cur = queue.poll();

                if (cur == n * n)
                    return res;

                if (!set.contains(cur))
                {
                    for (int j = cur + 1; j <= cur + 6 && j < nums.length; j++)
                    {
                        if (nums[j] != -1)
                            queue.offer(nums[j]);
                        else
                            queue.offer(j);
                    }
                    set.add(cur);
                }
            }

            res++;
        }

        return -1;
    }
}
