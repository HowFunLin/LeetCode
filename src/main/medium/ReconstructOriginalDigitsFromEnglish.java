package main.medium;

@SuppressWarnings("unused")
public class ReconstructOriginalDigitsFromEnglish {
    /**
     * 423. 从英文中重建数字
     *
     * @param s 字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）
     * @return 原始的数字（升序）
     */
    public String originalDigits(String s) {
        int[] countLetter = new int[26];

        for (int i = 0; i < s.length(); i++)
            countLetter[s.charAt(i) - 'a']++;

        int[] countNumber = new int[10];

        countNumber[0] = countLetter['z' - 'a'];
        countNumber[2] = countLetter['w' - 'a'];
        countNumber[4] = countLetter['u' - 'a'];
        countNumber[6] = countLetter['x' - 'a'];
        countNumber[8] = countLetter['g' - 'a'];

        countNumber[1] = countLetter['o' - 'a'] - countNumber[0] - countNumber[2] - countNumber[4];
        countNumber[3] = countLetter['t' - 'a'] - countNumber[2] - countNumber[8];
        countNumber[5] = countLetter['f' - 'a'] - countNumber[4];
        countNumber[7] = countLetter['s' - 'a'] - countNumber[6];

        countNumber[9] = (countLetter['n' - 'a'] - countNumber[1] - countNumber[7]) / 2;

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 10; i++)
            for (int j = 0; j < countNumber[i]; j++)
                builder.append(i);

        return builder.toString();
    }
}
