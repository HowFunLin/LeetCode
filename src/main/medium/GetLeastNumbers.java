package main.medium;

import java.util.ArrayList;
import java.util.PriorityQueue;

@SuppressWarnings("unused")
public class GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        if (k > input.length)
            return list;

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : input)
            heap.add(num);

        for (int i = 0; i < k; i++)
            list.add(heap.poll());

        return list;
    }
}
