package company;

import java.util.LinkedList;

@SuppressWarnings("unused")
public class Honor {
    /**
     * 模拟读取数据，每次输出字符不能超过20个，输出的字符之间用;隔开
     *
     * @param strs  标准输入
     * @param start 起始索引（从 1 开始）
     * @param sum   需要读取字符的总数
     */
    public void print(String[] strs, int start, int sum) {
        StringBuilder builder = new StringBuilder();
        int times = 0; // 记录读取次数

        // 遍历打印
        for (int i = start - 1; i < start - 1 + sum; i++) {
            if (i == strs.length)
                break;

            builder.append(strs[i]).append(";");
            times++;

            // 等于20次输出一次
            if (times == 20) {
                builder.deleteCharAt(builder.length() - 1);
                System.out.println(builder.toString());
                builder.delete(0, builder.length());
                times = 0;
            }
        }

        // 输出剩余且未满20的
        if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
            System.out.println(builder.toString());
        }
    }

    /**
     * 精简文本指令系统
     * i ：指定行前插入行
     * a ：指定行后插入行
     * r ：替换指定行
     * d ：删除指定行
     * | ：分割复合指令
     *
     * @param complex 复合指令或单条指令
     */
    public void commandCreateText(String complex) {
        // 指令之间用 | 分割
        String[] commands = complex.split("\\|");

        // 最终得到的文本
        LinkedList<String> txt = new LinkedList<>();

        for (int i = 0; i < commands.length; i++) {
            // 指令内部用 空格 隔开字符
            String[] words = commands[i].split(" ");

            // 首条指令限制：行号 1 ， 只能是插入指令 i ，否则报错
            if (i == 0) {
                if (!words[0].equals("1") || !words[1].equals("i")) {
                    System.out.println("error");
                    return;
                }

                txt.add(commands[i].substring(4));
                continue;
            }

            int line = Integer.valueOf(words[0]);

            // 操作的行号只能小于或等于当前行数
            if (line > txt.size()) {
                System.out.println("error");
                return;
            }

            String name = words[1];

            if ("a".equals(name))
                txt.add(line, commands[i].substring(4));

            if ("i".equals(name))
                txt.add(line - 1, commands[i].substring(4));

            if ("r".equals(name))
                txt.set(line - 1, commands[i].substring(4));

            if ("d".equals(name))
                txt.remove(line - 1);
        }

        // 输出文本
        for (String s : txt)
            System.out.println(s);
    }
}
