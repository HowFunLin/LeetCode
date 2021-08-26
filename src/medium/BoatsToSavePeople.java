package medium;

import java.util.Arrays;

@SuppressWarnings("unused")
public class BoatsToSavePeople {
    /**
     * 881. 救生艇
     *
     * @param people 第 i 个人的体重为 people[i]
     * @param limit  每艘船可以承载的最大重量为 limit， 每艘船最多可同时载两人
     * @return 载到每一个人所需的最小船数
     */
    public int numRescueBoats(int[] people, int limit) {
        int res = 0;
        Arrays.sort(people);
        int left = 0, right = people.length - 1;

        while (left <= right) {
            if (people[left] + people[right] <= limit)
                left++;

            right--;
            res++;
        }

        return res;
    }
}
