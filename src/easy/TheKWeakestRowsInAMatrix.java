package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TheKWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Integer> indexToSoldiers = new HashMap<>();
        int row = mat.length, col = mat[0].length;
        Integer[] all = new Integer[row];

        for (int i = 0; i < row; i++)
        {
            int soldier = 0;

            for (int j = 0; j < col; j++)
                if (mat[i][j] == 1)
                    soldier++;

            indexToSoldiers.put(i, soldier);
            all[i] = i;
        }

        Arrays.sort(all, (a, b) -> {
            Integer x = indexToSoldiers.get(a);
            Integer y = indexToSoldiers.get(b);

            return x == y ? a - b : x - y;
        });

        int[] ans = new int[k];

        for (int i = 0; i < k; i++)
            ans[i] = all[i];

        return ans;
    }
}
