package main.medium;

@SuppressWarnings("unused")
public class PushDominoes {
    /**
     * 838. 推多米诺
     *
     * @param dominoes 字符串 dominoes 表示这一行多米诺骨牌的初始状态，其中：dominoes[i] = 'L'，表示第 i 张多米诺骨牌被推向左侧，dominoes[i] = 'R'，表示第 i 张多米诺骨牌被推向右侧，dominoes[i] = '.'，表示没有推动第 i 张多米诺骨牌
     * @return 表示最终状态的字符串
     */
    public String pushDominoes(String dominoes) {
        dominoes = "L" + dominoes + "R"; // 拼接虚拟牌不影响结果

        StringBuilder res = new StringBuilder();
        int l = 0;

        for (int r = 1; r < dominoes.length(); ++r) {
            if (dominoes.charAt(r) == '.')
                continue;

            if (l != 0)  // 虚拟的牌不放入结果
                res.append(dominoes.charAt(l));

            int mid = r - l - 1;

            if (dominoes.charAt(l) == dominoes.charAt(r)) // 相同时，更新当前位置为新的判断坐标并更新区间为对应倒向
                for (int i = 0; i < mid; ++i)
                    res.append(dominoes.charAt(l));
            else if (dominoes.charAt(l) == 'L' && dominoes.charAt(r) == 'R') // 指针之间的元素不被推倒
                for (int i = 0; i < mid; ++i)
                    res.append('.');
            else { // 指针之间的元素互相倒向
                for (int i = 0; i < mid / 2; ++i)
                    res.append('R');

                if (mid % 2 == 1)
                    res.append('.');

                for (int i = 0; i < mid / 2; ++i)
                    res.append('L');
            }

            l = r; // 只有当前位置为被推倒的牌时才会更新 l 指针
        }

        return res.toString();
    }
}
