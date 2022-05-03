package main.easy;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class ReorderDataInLogFiles {
    /**
     * 937. 重新排列日志文件
     *
     * @param logs 日志数组 logs，每条日志都是以空格分隔的字串，其第一个字为字母与数字混合的 标识符。
     *             <p>字母日志：除标识符之外，所有字均由小写字母组成；
     *             <p>数字日志：除标识符之外，所有字均由数字组成。
     * @return 日志的最终顺序：
     * <p>所有 字母日志 都排在 数字日志 之前；
     * <p>字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序；
     * <p>数字日志 应该保留原来的相对顺序。
     */
    public String[] reorderLogFiles(String[] logs) {
        List<String> letters = new ArrayList<>(), numbers = new ArrayList<>();

        for (String log : logs) {
            char c = log.charAt(log.length() - 1);

            if (Character.isLetter(c))
                letters.add(log);
            else
                numbers.add(log);
        }

        letters.sort((o1, o2) -> {
            int space1 = o1.indexOf(" "), space2 = o2.indexOf(" ");

            String identifier1 = o1.substring(0, space1), identifier2 = o2.substring(0, space2);
            String log1 = o1.substring(space1 + 1), log2 = o2.substring(space2 + 1);

            if (log1.equals(log2))
                return identifier1.compareTo(identifier2);

            return log1.compareTo(log2);
        });

        String[] res = new String[logs.length];

        int i = 0;

        for (String letter : letters)
            res[i++] = letter;

        for (String number : numbers)
            res[i++] = number;

        return res;
    }
}
