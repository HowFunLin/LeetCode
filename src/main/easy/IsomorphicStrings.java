package main.easy;

@SuppressWarnings("unused")
public class IsomorphicStrings {
    /**
     * 205. 同构字符串
     *
     * @param s 字符串
     * @param t 字符串
     * @return 判断字符串 s 和 t 是否是同构的。如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
     * 不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身
     */
    public boolean isIsomorphic(String s, String t) {
        char[] mappingS = new char[128], mappingT = new char[128]; // 互相唯一映射

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);

            // 映射存在时进行判断，必须满足映射均存在且互相映射
            if ((mappingS[sc] != 0 && mappingS[sc] != tc) || (mappingT[tc] != 0 && mappingT[tc] != sc))
                return false;

            // 当前映射不存在，则将当前映射加入
            mappingS[sc] = tc;
            mappingT[tc] = sc;
        }

        return true;
    }
}
