package medium;

import java.util.HashMap;

public class SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        HashMap<Integer, Integer> need = new HashMap<>();

        for (int num : nums)
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);

        for (int num : nums) {
            if (frequency.get(num) == 0)
                continue;
            if (need.containsKey(num) && need.get(num) > 0) {
                frequency.put(num, frequency.get(num) - 1);
                need.put(num, need.get(num) - 1);
                need.put(num + 1, need.getOrDefault(num + 1, 0) + 1);
            } else if (frequency.getOrDefault(num, 0) > 0 &&
                    frequency.getOrDefault(num + 1, 0) > 0 &&
                    frequency.getOrDefault(num + 2, 0) > 0) {
                frequency.put(num, frequency.get(num) - 1);
                frequency.put(num + 1, frequency.get(num + 1) - 1);
                frequency.put(num + 2, frequency.get(num + 2) - 1);
                need.put(num + 3, need.getOrDefault(num + 3, 0) + 1);
            } else
                return false;
        }

        return true;
    }
}
