package main.medium;

import struct.ListNode;

@SuppressWarnings("unused")
public class SplitLinkedListInParts {
    /**
     * 725. 分隔链表
     *
     * @param head 头结点为 head 的单链表
     * @param k    将链表分隔为 k 个连续的部分，每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 ；这可能会导致有些部分为 null；这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度
     * @return 由上述 k 部分组成的数组
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];

        if (head == null)
            return res;

        ListNode ptr = head;
        int length = 1;

        while (ptr.next != null) {
            ptr = ptr.next;
            length++;
        }

        int nodes = length / k, plus = length % k;

        ptr = head;

        for (int i = 0; i < k && ptr != null; i++) {
            res[i] = ptr;

            int resLength = nodes + (i < plus ? 1 : 0);

            for (int j = 1; j < resLength; j++)
                ptr = ptr.next;

            ListNode next = ptr.next;
            ptr.next = null;
            ptr = next;
        }

        return res;
    }
}
