package easy;

import structure.ListNode;

public class GetKthFromEnd
{
	public ListNode getKthFromEnd(ListNode head, int k) {
		ListNode tar = head;	
		
		for(int i = 0; i < k; i++)
			head = head.next;
			
		while(head != null)
		{
			head = head.next;
			tar = tar.next;
		}
		
		return tar;
    }
}
