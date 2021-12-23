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

        if (rowIndex == 0)
            return res;

        res.add(1);

        if (rowIndex == 1)
            return res;

        for (int i = 2; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<>();

            temp.add(1);

            for (int j = 1; j < i; j++)
                temp.add(res.get(j - 1) + res.get(j));

            temp.add(1);

            res = temp;
        }

        return res;
    }
}
