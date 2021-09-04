package main.easy;

import java.util.ArrayList;

public class FirstUniqueCharacter
{
	public char firstUniqChar(String s) {
		char[] cs = s.toCharArray();
		int[] times = new int[26];
		ArrayList<Character> list = new ArrayList<Character>();
		
		for(int i = 0; i < cs.length; i++)
		{
			times[cs[i] % 97]++;
			
			if(times[cs[i] % 97] == 1)
				list.add(cs[i]);
			else if(times[cs[i] % 97] == 2)
				list.remove((Character)cs[i]);
			else
				continue;
		}
		
		return list.size() > 0 ? list.get(0) : ' ';
    }
}
