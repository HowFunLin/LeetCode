package medium;

@SuppressWarnings("unused")
public class CompareVersionNumbers {
    /**
     * <h3>165. 比较版本号</h3>
     * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。
     * 比较修订号时，只需比较 忽略任何前导零后的整数值 。
     *
     * @param version1 版本号 version1
     * @param version2 版本号 version2
     * @return 如果 version1 > version2 返回 1， 如果 version1 < version2 返回 -1， 除此之外返回 0。
     */
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\."), ver2 = version2.split("\\.");

        for (int i = 0; i < ver1.length || i < ver2.length; i++) {
            int v1 = i >= ver1.length ? 0 : Integer.valueOf(ver1[i]);
            int v2 = i >= ver2.length ? 0 : Integer.valueOf(ver2[i]);

            if (v1 != v2)
                return v1 > v2 ? 1 : -1;
        }

        return 0;
    }
}
