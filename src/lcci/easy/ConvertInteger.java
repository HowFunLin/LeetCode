package lcci.easy;

@SuppressWarnings("unused")
public class ConvertInteger {
    /**
     * 面试题 05.06. 整数转换
     *
     * @param A 整数
     * @param B 整数
     * @return 将整数A转成整数B需要改变的位数
     */
    public int convertInteger(int A, int B) {
        return Integer.bitCount(A ^ B);
    }
}
