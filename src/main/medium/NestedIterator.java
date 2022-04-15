package main.medium;

import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer>
{
//	private Iterator<Integer> it;
//	
//	public NestedIterator(List<NestedInteger> nestedList)
//	{
//		List<Integer> list = new LinkedList<Integer>();
//		
//		for(NestedInteger node : nestedList)
//			traversal(node, list);
//		
//		this.it = list.iterator();
//	}
//
//	@Override
//	public Integer next()
//	{
//		return it.next();
//	}
//
//	@Override
//	public boolean hasNext()
//	{
//		return it.hasNext();
//	}
//	
//	private void traversal(NestedInteger root, List<Integer> list)
//	{
//		if(root.isInteger())
//		{
//			list.add(root.getInteger());
//			return;
//		}
//		
//		for(NestedInteger node : root.getList())
//			traversal(node, list);
//	}

	private List<NestedInteger> nestedList;
	private int size;
	private int i = 0;
	private NestedIterator iterator = null;

	public NestedIterator(List<NestedInteger> nestedList)
	{
		this.nestedList = nestedList;
		size = nestedList.size();
	}

	@Override
	public Integer next()
	{
		NestedInteger curr = nestedList.get(i);
		if (curr.isInteger())
		{
			i++;
			return curr.getInteger();
		} else
			return iterator.next();
	}

	@Override
	public boolean hasNext()
	{
		while (i < size)
		{
			NestedInteger curr = nestedList.get(i);
			if (curr.isInteger())
				return true;
			else
			{
				if (iterator == null)
					iterator = new NestedIterator(curr.getList());

				if (iterator.hasNext())
					return true;
				else
				{
					iterator = null;
					i++;
				}
			}
		}

		return false;
	}

	interface NestedInteger
	{
		// @return true if this NestedInteger holds a single integer, rather than a
		// nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds a
		// single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a nested
		// list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}
}