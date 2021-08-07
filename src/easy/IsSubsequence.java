package easy;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int si = 0, ti = 0;

        while (ti < tc.length && si < sc.length)
        {
            if (sc[si] == tc[ti])
                si++;

            ti++;
        }

        return si == sc.length ? true : false;
    }
}
