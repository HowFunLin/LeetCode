package main.medium;

import struct.ListNode;

public class SwapNodesInPairs
{
	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null)
			return head;
		
		ListNode newhead = head.next;
		
		while(head != null)
		{
			if(head.next == null)
                break;
			
			ListNode two = head.next;
			head.next = two.next;
			two.next = head;
			ListNode oldhead = head;
			head = head.next;
			
			if(head == null)
				break;
			
			if(head.next == null)
				oldhead.next = head;
			else
				oldhead.next = head.next;
		}
		
		return newhead;
    }
}