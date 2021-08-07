package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutation {
    private List<String> res = new ArrayList<>();
    private StringBuilder builder = new StringBuilder();
    private boolean[] vis;

    public String[] permutation(String s) {
        vis = new boolean[s.length()];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        backstrack(arr, 0, s.length());

        return res.toArray(new String[res.size()]);
    }

    private void backstrack(char[] arr, int index, int length)
    {
        if (index == length)
        {
            res.add(builder.toString());
            return;
        }

        for (int i = 0; i < length; i++)
        {
            if (vis[i] || (i > 0 && !vis[i - 1] && arr[i - 1] == arr[i])) {
                continue;
            }
            vis[i] = true;
            builder.append(arr[i]);
            backstrack(arr, index + 1, length);
            builder.deleteCharAt(builder.length() - 1);
            vis[i] = false;
        }
    }
}
