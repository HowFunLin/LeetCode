package main.medium;

@SuppressWarnings("unused")
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int max = 0;

        for (int num : nums)
            max = Math.max(num, max);

        int[] houses = new int[max + 1];

        for (int num : nums)
            houses[num] += num;

        int first = houses[0];
        int second = Math.max(houses[0], houses[1]);

        for (int i = 2; i < houses.length; i++) {
            int temp = second;
            second = Math.max(first + houses[i], second);
            first = temp;
        }

        return second;
    }
}
