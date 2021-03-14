package medium;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode newList = new ListNode();
		ListNode head = newList;
		ListNode tail = null;

		int up = 0;

		while (l1 != null || l2 != null) {
			int l1v = 0;
			int l2v = 0;

			if (l1 != null) {
				l1v = l1.val;
				if (l1.next == null)
					tail = newList;
				l1 = l1.next;
			}
			if (l2 != null) {
				l2v = l2.val;
				if (l2.next == null)
					tail = newList;
				l2 = l2.next;
			}

			int value = l1v + l2v + up;
			up = 0;

			if (value > 9) {
				value %= 10;
				up = 1;
			}

			newList.val = value;

			newList.next = new ListNode();
			newList = newList.next;
		}

		if (up == 1)
			newList.val = 1;
		else
			tail.next = null;

		return head;
	}
}