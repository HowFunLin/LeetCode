package lcci.easy;

@SuppressWarnings("unused")
public class IsUnique {
    /**
     * 面试题 01.01. 判定字符是否唯一
     *
     * @param astr 字符串
     * @return 字符串 astr 中的所有字符是否全都不同
     */
    public boolean isUnique(String astr) {
        boolean[] visited = new boolean[128];

        for (int i = 0; i < astr.length(); i++) {
            char cur = astr.charAt(i);

            if (!visited[cur])
                visited[cur] = true;
            else
                return false;
        }

        return true;
    }
}
