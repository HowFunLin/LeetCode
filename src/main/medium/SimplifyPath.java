package main.medium;

import java.util.Stack;

@SuppressWarnings("unused")
public class SimplifyPath {
    /**
     * 71. 简化路径
     *
     * @param path 字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头）
     * @return 简化后得到的 规范路径 。规范路径 始终以斜杠 '/' 开头；两个目录名之间必须只有一个斜杠 '/'；最后一个目录名（如果存在）不能 以 '/' 结尾；路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);

            if (c == '/') {
                if (builder.length() != 0) {
                    opt(stack, builder);
                }
            } else
                builder.append(c);
        }

        if (builder.length() != 0)
            opt(stack, builder);

        if (stack.isEmpty())
            return "/";

        while (!stack.isEmpty())
            builder.insert(0, "/" + stack.pop());

        return builder.toString();
    }

    private void opt(Stack<String> stack, StringBuilder builder) {
        String s = builder.toString();

        switch (s) {
            case ".":
                break;
            case "..":
                if (!stack.isEmpty())
                    stack.pop();
                break;
            case "":
                break;
            default:
                stack.push(s);
                break;
        }

        builder.delete(0, builder.length());
    }
}
