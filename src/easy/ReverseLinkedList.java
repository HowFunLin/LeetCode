package easy;

import structure.ListNode;

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		if (head == null)
			return head;

		if (head.next != null) {
			ListNode end = head.next;

			while (end.next != null)
				end = end.next;

			while (head.val != end.val) {
				ListNode opt = head;
				head = head.next;

				opt.next = end.next;
				end.next = opt;
			}
		}

		return head;
	}
}