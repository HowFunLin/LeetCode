package main.medium;

import java.util.Arrays;
import java.util.LinkedList;

public class RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        LinkedList<Integer> index = new LinkedList<>();
        Arrays.sort(deck);
        int[] res = new int[deck.length];

        for (int i = 0; i < deck.length; i++)
            index.add(i);

        for (int num : deck)
        {
            res[index.pollFirst()] = num;
            if (!index.isEmpty())
                index.add(index.pollFirst());
        }

        return res;
    }
}
