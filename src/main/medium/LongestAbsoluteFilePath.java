package main.medium;

@SuppressWarnings("unused")
public class LongestAbsoluteFilePath {
    /**
     * 388. 文件的最长绝对路径
     *
     * @param input 表示文件系统的字符串。'\n' 和 '\t' 分别是换行符和制表符
     * @return 文件系统中 指向 文件 的 最长绝对路径 的长度 。 如果系统中没有文件，返回 0
     */
    public int lengthLongestPath(String input) {
        int n = input.length(), res = 0, ptr = 0;
        int[] depths = new int[n + 1];

        // 每执行一次 while 内代码，ptr 遍历一行文件描述
        while (ptr < n) {
            // 计算当前文件（夹）所在的深度（从 1 开始）
            int depth = 1;

            while (ptr < n && input.charAt(ptr) == '\t') {
                ptr++;
                depth++;
            }

            // 计算当前文件（夹）名称的长度和判断是否文件
            int length = 0;
            boolean isFile = false;

            while (ptr < n && input.charAt(ptr) != '\n') {
                if (input.charAt(ptr) == '.')
                    isFile = true;

                length++;
                ptr++;
            }

            // 跳过换行符到达下一个单词
            ptr++;

            if (depth > 1)
                length += depths[depth - 1] + 1; // + 1 为加上换行符的长度

            if (isFile)
                res = Math.max(res, length);
            else
                depths[depth] = length; // 保证实时更新为当前文件夹名称长度而不是之前的文件夹名称长度
        }

        return res;
    }
}
