package easy;

import structure.ListNode;

public class PrintListFromTailToHead
{
	public int[] reversePrint(ListNode head)
	{
		ListNode opt = head;
		int len = 0;
		
		while (opt != null)
		{
			opt = opt.next;
			len++;
		}

		int[] arr = new int[len];
		
		for(int i = len - 1; i >= 0; i--)
		{
			arr[i] = head.val;
			head = head.next;
		}
		
		return arr;
	}
}
