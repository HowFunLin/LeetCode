package week;

import java.util.Arrays;

public class Game_247 {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;

        return nums[n] * nums[n - 1] - nums[0] * nums[1];
    }

    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < k; i++)
        {
            for (int j = 0; j < (m < n ? m : n) / 2; j++)
            {
                int start = grid[j][j];

                for (int l = j; l < n - j - 1; l++)
                    grid[j][l] = grid[j][l + 1];

                for (int l = j; l < m - j - 1; l++)
                    grid[l][n - j - 1] = grid[l + 1][n - j - 1];

                for (int l = n - j - 1; l > 0; l--)
                    grid[m - j - 1][l] = grid[m - j - 1][l - 1];

                for (int l = m - j - 1; l > j + 1; l--)
                    grid[l][j] = grid[l - 1][j];

                grid[j + 1][j] = start;
            }
        }

        return grid;
    }

    public long wonderfulSubstrings(String word) {
        char[] words = word.toCharArray();
        long res = 0;

        for (int i = 0; i < words.length; i++)
        {
            int[] counts = new int[10];

            for (int j = i; j < words.length; j++)
            {
                counts[words[j] - 'a']++;

                int num = 0;
                for (int count : counts)
                {
                    if (count % 2 == 1)
                        num++;
                }

                if (num <= 1)
                    res++;
            }
        }

        return res;
    }
}
