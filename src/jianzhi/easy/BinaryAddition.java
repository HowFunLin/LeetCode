package jianzhi.easy;

@SuppressWarnings("unused")
public class BinaryAddition {
    /**
     * 剑指 Offer II 002. 二进制加法
     *
     * @return 两个 01 字符串 a 和 b 的和的二进制字符串形式
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        // 可视作将不足的位补齐
        while (i >= 0 || j >= 0) {
            int bitA = (i >= 0) ? a.charAt(i) - '0' : 0;
            int bitB = (j >= 0) ? b.charAt(j) - '0' : 0;

            int bit = bitA + bitB + carry;

            sb.append(bit % 2);
            carry = bit / 2;

            i--;
            j--;
        }

        if (carry != 0)
            sb.append(carry);

        return sb.reverse().toString();
    }
}
