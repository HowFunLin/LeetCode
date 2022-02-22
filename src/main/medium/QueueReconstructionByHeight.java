package main.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class QueueReconstructionByHeight {
    /**
     * 406. 根据身高重建队列
     *
     * @param people people[i] = [h, k] 表示第 i 个人的身高为 h ，前面 正好 有 k 个身高大于或等于 h 的人
     * @return 输入数组 people 所表示的队列
     */
    public int[][] reconstructQueue(int[][] people) {
        // 从低到高排列
//        Arrays.sort(people, (person1, person2) -> {
//            if (person1[0] != person2[0])
//                return person1[0] - person2[0];
//            else
//                return person2[1] - person1[1];
//        });
//
//        int n = people.length;
//        int[][] res = new int[n][];
//
//        for (int[] person : people) {
//            int spaces = person[1] + 1; // 前面有 person[1] 个人更高则位置为 person[1] + 1
//
//            for (int i = 0; i < n; i++) {
//                if (res[i] == null) { // 索引位置不为空，不影响当前人的前面更高的人数（排序后当前人比已在队中的任何人更高）
//                    spaces--;
//
//                    if (spaces == 0) {
//                        res[i] = person;
//                        break;
//                    }
//                }
//            }
//        }
//
//        return res;

        // 从高到低排列
        Arrays.sort(people, (person1, person2) -> person1[0] != person2[0] ? person2[0] - person1[0] : person1[1] - person2[1]);

        List<int[]> res = new ArrayList<>();

        for (int[] person : people)
            res.add(person[1], person);

        return res.toArray(new int[0][]);
    }
}
