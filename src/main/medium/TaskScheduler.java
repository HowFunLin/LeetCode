package main.medium;

@SuppressWarnings("unused")
public class TaskScheduler {
    /**
     * 621. 任务调度器
     *
     * @param tasks 字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态
     * @param n     两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间
     * @return 完成所有任务所需要的 最短时间
     */
    public int leastInterval(char[] tasks, int n) {
        int[] table = new int[26];
        int maxExec = 0; // 最大执行行数

        for (char task : tasks) {
            table[task - 'A']++;
            maxExec = Math.max(maxExec, table[task - 'A']);
        }

        int maxCount = 0;

        for (int i : table)
            if (i == maxExec)
                maxCount++;

        // 构造时，按 maxExec * ( n + 1 ) 构造方格，从下到上从左到右填充，如果填充时列数大于 n + 1，则执行无需等待
        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
    }
}
