package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathInZigzagLabelledBinaryTree {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();

        int row = 0, num = 1;
        while (num <= label) {
            num *= 2;
            row++;
        }

        // 若一开始的值在偶数行，则需提前进行处理
        if (row % 2 == 0)
            label = (1 << (row - 1)) + (1 << row) - 1 - label; // 该列可能的最大 + 最小 - label，得出所在的位置

        for (; row > 0; row--) {
            if (row % 2 == 0)
                res.add((1 << (row - 1)) + (1 << row) - 1 - label);
            else
                res.add(label);

            label >>= 1;
        }

        Collections.reverse(res);
        return res;
    }
}
