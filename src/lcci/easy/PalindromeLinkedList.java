package lcci.easy;

import struct.ListNode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class PalindromeLinkedList {
    /**
     * 面试题 02.06. 回文链表
     *
     * @param head 链表头
     * @return 输入的链表是否是回文的
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;

        List<Integer> list = new ArrayList<>();
        ListNode ptr = head;

        while (ptr != null) {
            list.add(ptr.val);
            ptr = ptr.next;
        }

        for (int left = 0, right = list.size() - 1; left < right; left++, right--) {
            if (!list.get(left).equals(list.get(right)))
                return false;
        }

        return true;
    }
}
