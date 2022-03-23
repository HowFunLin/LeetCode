package main.easy;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class PascalsTriangleII {
    /**
     * 119. 杨辉三角 II
     *
     * @param rowIndex 非负索引 rowIndex
     * @return 「杨辉三角」的第 rowIndex 行
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();

        res.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            res.add(0);

            for (int j = i; j > 0; j--)
                res.set(j, res.get(j) + res.get(j - 1));
        }

        return res;
    }
}
