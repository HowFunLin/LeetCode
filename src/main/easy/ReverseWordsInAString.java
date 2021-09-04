package main.easy;

public class ReverseWordsInAString
{
	public String reverseWords(String s)
	{
		String[] split = s.split(" ");
		StringBuilder sb = new StringBuilder();

		for (int i = split.length - 1; i >= 0; i--)
		{
			if (split[i].isBlank())
				continue;

			if (i != 0)
				sb.append(split[i].trim() + " ");
			else
				sb.append(split[i].trim());
		}

		return sb.toString().trim();
	}
}
