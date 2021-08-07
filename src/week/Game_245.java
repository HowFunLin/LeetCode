package week;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Game_245 {
    public boolean makeEqual(String[] words) {
        int[] nums = new int[26];

        for (int i = 0; i < words.length; i++)
        {
            char[] chars = words[i].toCharArray();
            for (char c : chars)
            {
                nums[c - 'a']++;
            }
        }

        for (int num : nums)
        {
            if (num % words.length != 0)
                return false;
        }

        return true;
    }

    public int maximumRemovals(String s, String p, int[] removable) {
        // ...
        return 0;
    }

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean target_0 = false, target_1 = false, target_2 = false;

        for (int i = 0; i < triplets.length; i++)
        {
            if (triplets[i][0] == target[0] && triplets[i][1] == target[1] && triplets[i][2] == target[2])
                return true;

            if (triplets[i][0] == target[0] && triplets[i][1] <= target[1] && triplets[i][2] <= target[2])
                target_0 = true;

            if (triplets[i][0] <= target[0] && triplets[i][1] == target[1] && triplets[i][2] <= target[2])
                target_1 = true;

            if (triplets[i][0] <= target[0] && triplets[i][1] <= target[1] && triplets[i][2] == target[2])
                target_2 = true;
        }

        return target_0 & target_1 & target_2;
    }
}
