package medium;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        List<List<Integer>> result = new ArrayList<>();

        while (i < firstList.length && j < secondList.length)
        {
            int first1 = firstList[i][0], first2 = firstList[i][1];
            int second1 = secondList[j][0], second2 = secondList[j][1];

            if (first1 <= second2 && second1 <= first2)
            {
                List<Integer> list = new ArrayList<>();
                list.add(Math.max(first1, second1));
                list.add(Math.min(first2, second2));
                result.add(list);
            }

            if (first2 > second2)
                j++;
            else
                i++;
        }

        int[][] resultArray = new int[result.size()][2];

        int index = 0;
        for (List<Integer> l : result)
        {
            resultArray[index][0] = l.get(0);
            resultArray[index][1] = l.get(1);
            index++;
        }

        return resultArray;
    }
}
