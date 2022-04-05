package main.easy;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class PositionsOfLargeGroups {
    /**
     * 830. 较大分组的位置
     *
     * @param s 由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组，称所有包含大于或等于三个连续字符的分组为 较大分组
     * @return 每一个 较大分组 的区间，按起始位置下标递增顺序排序后 的结果
     */
    public List<List<Integer>> largeGroupPositions(String s) {
        s += ' ';

        List<List<Integer>> res = new LinkedList<>();

        char c = s.charAt(0);
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (cur != c) {
                if (i - start >= 3) {
                    List<Integer> sub = new LinkedList<>();

                    sub.add(start);
                    sub.add(i - 1);

                    res.add(sub);
                }

                start = i;
                c = cur;
            }
        }

        return res;
    }
}
