package main.easy;

public class QuickCalculateRobot
{
	public int calculate(String s) {
		int x = 1;
		int y = 0;
		
		char[] cs = s.toCharArray();
		
		for(int i = 0; i < cs.length; i++)
		{
			if(cs[i] == 'A')
				x = 2 * x + y;
			else if(cs[i] == 'B')
				y = 2 * y + x;
		}
		
		return x + y;
    }
}
