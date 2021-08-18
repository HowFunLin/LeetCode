package medium;

import struct.ListNode;

public class ReverseLinkedListII
{
	public ListNode reverseBetween(ListNode head, int left, int right)
	{
		ListNode old = head;
		ListNode newh = head;
		ListNode newt = head;
		ListNode lefth = null;
		ListNode rightt = null;
		ListNode temp = null;

		for (int i = 1; i < right; i++)
			newh = newh.next;
		rightt = newh.next;

		for (int i = 1; i < left; i++)
		{
			if (i == left - 1)
				lefth = newt;
			newt = newt.next;
		}

		if (lefth != null)
			lefth.next = newh;
		newh.next = rightt;

		for (int i = 0; i < right - left; i++)
		{
			temp = newt.next;
			newt.next = newh.next;
			newh.next = newt;
			newt = temp;
		}

		if (lefth == null)
			return newh;

		return old;
	}
}
