package main.easy;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 X 可以放在 L (50) 和 C (100) 的左边，来表示 40
 * 和 90。  C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 给定一个罗马数字，将其转换成整数。输入确保在 1
 * 到 3999 的范围内。
 * 
 * @author Riyad
 *
 */
public class RomanToInteger
{
	public static void main(String[] args)
	{
		RomanToInteger rti = new RomanToInteger();
		
		System.out.println(rti.romanToInt("MCMXCIV"));
	}

	/**
	 * 罗马数字转整数
	 * 
	 * @param s 罗马数字
	 * @return 罗马数字的整数表示
	 */
	public int romanToInt(String s)
	{
		char[] str = s.toCharArray();
		int len = str.length, number = 0;

		for (int i = 0; i < len; i++)
		{
			switch (str[i])
			{
			
			case 'M':
				number += 1000;
				break;
				
			case 'D':
				number += 500;
				break;
				
			case 'C':
				if (i + 1 < len && (str[i + 1] == 'M' || str[i + 1] == 'D'))
					number -= 100;
				else
					number += 100;
				break;
				
			case 'L':
				number += 50;
				break;
				
			case 'X':
				if (i + 1 < len && (str[i + 1] == 'C' || str[i + 1] == 'L'))
					number -= 10;
				else
					number += 10;
				break;
				
			case 'V':
				number += 5;
				break;
				
			case 'I':
				if (i + 1 < len && (str[i + 1] == 'V' || str[i + 1] == 'X'))
					number -= 1;
				else
					number += 1;
				break;
			}
		}
		
		return number;
	}
}
