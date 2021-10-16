package lcci.medium;

import struct.ListNode;

@SuppressWarnings("unused")
public class SumLists {
    /**
     * 面试题 02.05. 链表求和
     *
     * @param l1 用链表表示的整数，每个节点包含一个数位，数位是反向存放的，也就是个位排在链表首部
     * @param l2 用链表表示的整数，每个节点包含一个数位，数位是反向存放的，也就是个位排在链表首部
     * @return 链表形式两个整数求和的结果
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), ptr = dummy;
        boolean carry = false;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + (carry ? 1 : 0);

            if (carry)
                carry = false;

            if (sum >= 10) {
                sum %= 10;
                carry = true;
            }

            ptr.next = new ListNode(sum);
            ptr = ptr.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null)
            ptr.next = l2;
        else
            ptr.next = l1;

        if (carry) {
            if (ptr.next == null)
                ptr.next = new ListNode(1);
            else {
                while (ptr.next != null && ptr.next.val + 1 == 10) {
                    ptr.next.val = 0;
                    ptr = ptr.next;
                }

                if (ptr.next == null)
                    ptr.next = new ListNode(1);
                else
                    ptr.next.val += 1;
            }
        }

        return dummy.next;
    }
}
