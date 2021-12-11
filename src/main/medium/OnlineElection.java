package main.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 911. 在线选举
 */
@SuppressWarnings("unused")
public class OnlineElection {
    class TopVotedCandidate {
        private Map<Integer, Integer> timeToLeader = new HashMap<>();
        private int[] votes, times;

        /**
         * 使用 persons 和 times 数组初始化对象，在选举中，第 i 张票是在时刻为 times[i] 时投给候选人 persons[i] 的
         *
         * @param persons 整数数组
         * @param times   整数数组
         */
        public TopVotedCandidate(int[] persons, int[] times) {
            votes = new int[persons.length];
            this.times = times;

            int max = 0, maxPerson = 0;

            for (int i = 0; i < persons.length; i++) {
                int curPerson = persons[i];
                int curVote = ++votes[curPerson];

                if (curVote >= max) {
                    max = curVote;
                    maxPerson = curPerson;
                }

                timeToLeader.put(times[i], maxPerson);
            }
        }

        /**
         * 查询在 t 时刻在选举中领先的候选人的编号
         *
         * @param t 时刻
         * @return 在时刻 t 在选举中领先的候选人的编号。在 t 时刻投出的选票也将被计入我们的查询之中。在平局的情况下，最近获得投票的候选人将会获胜
         */
        public int q(int t) {
            int left = 0, right = times.length - 1;

            while (left < right) {
                int mid = (right - left + 1) / 2 + left;

                if (times[mid] <= t)
                    left = mid;
                else
                    right = mid - 1;
            }

            return timeToLeader.get(times[left]);
        }
    }
}
