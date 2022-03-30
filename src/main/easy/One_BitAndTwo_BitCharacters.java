package main.easy;

@SuppressWarnings("unused")
public class One_BitAndTwo_BitCharacters {
    /**
     * 717. 1 比特与 2 比特字符
     *
     * @param bits 以 0 结尾的二进制数组 bits，字符可以用一比特 0 表示，也可以用两比特（10 或 11）表示
     * @return 最后一个字符是否必须是一个一比特字符
     */
    public boolean isOneBitCharacter(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == 1)
                i++;
            else if (bits[i] == 0 && i == bits.length - 1)
                return true;
        }

        return false;
    }
}
