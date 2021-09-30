package lcci.easy;

@SuppressWarnings("unused")
public class InsertIntoBits {
    /**
     * 面试题 05.01. 插入
     *
     * @param N 整型数字
     * @param M 整型数字
     * @param i 比特位置（i <= j，且从 0 位开始计算）
     * @param j 比特位置（i <= j，且从 0 位开始计算）
     * @return M 对应的二进制数字插入 N 对应的二进制数字的第 i ~ j 位区域，不足之处用 0 补齐后的结果
     */
    public int insertBits(int N, int M, int i, int j) {
        //              > j            i ~ j           < i
        return N >> j >> 1 << j << 1 | M << i | N & ((1 << i) - 1);
    }
}
