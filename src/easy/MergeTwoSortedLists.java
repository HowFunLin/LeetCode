package easy;

import struct.ListNode;

public class MergeTwoSortedLists
{
	public ListNode mergeTwoLists(ListNode l1, ListNode l2)
	{
		ListNode list;
		ListNode head = l1;
		
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		
		if(l1.val < l2.val)
		{
			list = l1;
			l1 = l1.next;
		}
		else
		{
			head = list = l2;
			l2 = l2.next;
		}
		
		while(l1 != null && l2 != null)
		{
			if(l1.val < l2.val)
			{
				list.next = l1;
				l1 = l1.next;
			}
			else
			{
				list.next = l2;
				l2 = l2.next;
			}
			
			list = list.next;
		}
		
		if(l1 == null)
			list.next = l2;
		else
			list.next = l1;

		return head;
	}
}
