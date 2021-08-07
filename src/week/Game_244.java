package week;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Game_244 {
    public boolean findRotation(int[][] mat, int[][] target) {
        String[] matStrs = new String[4];
        String[] targetStrs = new String[4];
        Arrays.fill(matStrs, "");
        Arrays.fill(targetStrs, "");

        int n = mat.length;

        for (int i = 0; i < n; i++)
        {
            matStrs[0] += mat[0][i];
            targetStrs[0] += target[0][i];

            matStrs[1] += mat[i][n - 1];
            targetStrs[1] += target[i][n - 1];
        }

        for (int i = n - 1; i >= 0; i--)
        {
            matStrs[2] += mat[n - 1][i];
            targetStrs[2] += target[n - 1][i];

            matStrs[3] += mat[i][0];
            targetStrs[3] += target[i][0];
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (set.contains(j))
                    continue;
                if (matStrs[i].equals(targetStrs[j]))
                {
                    set.add(j);
                    break;
                }
            }
        }

        return set.size() == 4;
    }

    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int now = nums[0];
        int preIndex = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++)
        {
            if (now != nums[i])
            {
                list.add(i - preIndex);
                preIndex = i;
                now = nums[i];
            }
        }

        list.add(nums.length - preIndex);

        int res = 0;

        for (int i = 1; i < list.size(); i++)
        {
            res += list.get(i) * i;
        }

        return res;
    }
}
