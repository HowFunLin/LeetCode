package main.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("unused")
public class LetterCombinationsOfAPhoneNumber {
    private List<String> res = new ArrayList<>();
    private StringBuilder temp = new StringBuilder();
    private HashMap<Character, char[]> map = new HashMap<>();

    {
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    /**
     * 17. 电话号码的字母组合
     *
     * @param digits 仅包含数字 2-9 的字符串
     * @return 所有它能表示的字母组合，数字到字母的映射与电话按键相同
     */
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return res;

        char[] chars = digits.toCharArray();
        backtrack(chars, 0);

        return res;
    }

    /**
     * 回溯
     *
     * @param digits 仅包含数字 2-9 的字符数组
     * @param index  数组下标
     */
    private void backtrack(char[] digits, int index) {
        if (temp.length() == digits.length) {
            res.add(temp.toString());
            return;
        }

        for (char cur : map.get(digits[index])) {
            temp.append(cur);
            backtrack(digits, index + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
