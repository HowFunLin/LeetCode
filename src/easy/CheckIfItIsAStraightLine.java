package easy;

/**
 * 1232. 缀点成线
 * 
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，
 * 
 * 其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 * 
 * 判断这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 * 
 * @author Riyad
 *
 */
public class CheckIfItIsAStraightLine
{
	public boolean checkStraightLine(int[][] coordinates)
	{
		if (coordinates.length == 2)
			return true;

		double x = coordinates[1][0] - coordinates[0][0];
		double y = coordinates[1][1] - coordinates[0][1];

		if (x == 0)
		{
			for (int i = 2; i < coordinates.length; i++)
			{
				x = coordinates[i][0] - coordinates[i - 1][0];

				if (x == 0)
					continue;
				else
					return false;
			}

			return true;
		}

		double k = y / x;

		for (int i = 2; i < coordinates.length; i++)
		{
			x = coordinates[i][0] - coordinates[i - 1][0];
			y = coordinates[i][1] - coordinates[i - 1][1];

			if (y / x == k)
				continue;
			else
				return false;
		}

		return true;
	}
}