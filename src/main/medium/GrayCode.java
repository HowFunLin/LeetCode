package main.medium;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class GrayCode {
    /**
     * 89. 格雷编码
     *
     * @param n n 位格雷码序列（详见 百度百科：格雷码）
     * @return 任一有效的 n 位格雷码序列
     */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();

        // 应用 格雷码 公式， g(i) = b(i + 1) ⊕ b(i), 0 ≤ i < n
        // ⊕ 是按位异或运算，g(i) 和 b(i) 分别表示 g 和 b 的第 i 位，且 b(n) = 0（最高位为 0）
        for (int i = 0; i < 1 << n; i++)
            res.add(i ^ (i >> 1));

        return res;
    }
}
