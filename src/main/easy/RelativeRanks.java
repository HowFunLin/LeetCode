package main.easy;

import java.util.Arrays;

@SuppressWarnings("unused")
public class RelativeRanks {
    /**
     * 506. 相对名次
     *
     * @param score score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同
     * @return 所有运动员的获奖情况数组 answer。 answer[i] 是第 i 位运动员的获奖情况。名次第 1 的运动员获金牌 "Gold Medal" 。名次第 2 的运动员获银牌 "Silver Medal" 。名次第 3 的运动员获铜牌 "Bronze Medal" 。从名次第 4 到第 n 的运动员，只能获得他们的名次编号
     */
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;

        String[] medals = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        int[][] ranks = new int[n][2];

        for (int i = 0; i < n; i++) {
            ranks[i][0] = score[i];
            ranks[i][1] = i;
        }

        Arrays.sort(ranks, (o1, o2) -> o2[0] - o1[0]);

        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            if (i < 3)
                answer[ranks[i][1]] = medals[i];
            else
                answer[ranks[i][1]] = String.valueOf(i + 1);
        }

        return answer;
    }
}
