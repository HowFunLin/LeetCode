package easy;

import structure.ListNode;

public class IntersectionOfTwoLinkedList
{
	public ListNode getIntersectionNode(ListNode headA, ListNode headB)
	{
		ListNode optA = headA, optB = headB;
//		boolean flagA = false, flagB = true;
//		
//		while(optA != null && optB != null)
//		{
//			if(optA == optB)
//				return optA;
//			
//			optA = optA.next;
//			optB = optB.next;
//			
//			if(optA == null && flagA == false)
//			{
//				optA = headB;
//				flagA = true;
//			}
//			
//			if(optB == null && flagB == false)
//			{
//				optB = headA;
//				flagB = true;
//			}
//		}
//		
//		return null;
		
		while(optA != optB)
		{
			optA = optA == null ? headA : optA.next;
			optB = optB == null ? headB : optB.next;
		}
		
		return optA;
	}
}
