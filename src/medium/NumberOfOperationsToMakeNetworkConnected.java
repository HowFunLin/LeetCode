package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class NumberOfOperationsToMakeNetworkConnected
{
	public int makeConnected(int n, int[][] connections)
	{
		if(connections.length < n-1)
            return -1;
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		int line = 0;

		for (int i = 0; i < connections.length; i++)
			line += union(map, set, connections[i]);

		HashSet<Integer> valueSet = new HashSet<Integer>();

		for (int e : map.values())
			valueSet.add(e);

		int num = valueSet.size() - 1 + n - set.size();

		if (line >= num)
			return num;
		else if (num == 1)
			return 0;
		else
			return -1;
	}

	private int union(HashMap<Integer, Integer> map, HashSet<Integer> set, int[] connection)
	{
		int computer1 = connection[0];
		int computer2 = connection[1];

		set.add(computer1);
		set.add(computer2);

		if (map.containsKey(computer1) && map.containsKey(computer2))
		{
			int root1 = map.get(computer1);
			int root2 = map.get(computer2);

			if (root1 == root2)
				return 1;
			else
			{
				Set<Integer> keySet = map.keySet();

				for (int key : keySet)
					if (map.get(key) == root2)
						map.put(key, root1);

				return 0;
			}
		} else if (map.containsKey(computer1))
		{
			map.put(computer2, map.get(computer1));

			return 0;
		} else if (map.containsKey(computer2))
		{
			map.put(computer1, map.get(computer2));

			return 0;
		} else
		{
			map.put(computer1, computer2);
			map.put(computer2, computer2);

			return 0;
		}
	}
}
