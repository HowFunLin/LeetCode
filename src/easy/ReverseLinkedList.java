package easy;

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

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}