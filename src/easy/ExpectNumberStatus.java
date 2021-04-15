package easy;

import java.util.HashSet;

public class ExpectNumberStatus
{
	public int expectNumber(int[] scores) {
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int score : scores)
			set.add(score);
		
		return set.size();
    }
}
