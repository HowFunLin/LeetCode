package main.easy;

@SuppressWarnings("unused")
public class RansomNote {
    /**
     * 383. 赎金信
     *
     * @param ransomNote 赎金信
     * @param magazine   杂志
     * @return ransomNote 能否由 magazines 里面的字符构成。magazine 中的每个字符只能在 ransomNote 中使用一次
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] table = new int[26];

        for (int i = 0; i < magazine.length(); i++)
            table[magazine.charAt(i) - 'a']++;

        for (int i = 0; i < ransomNote.length(); i++) {
            if (table[ransomNote.charAt(i) - 'a'] == 0)
                return false;

            table[ransomNote.charAt(i) - 'a']--;
        }

        return true;
    }
}
