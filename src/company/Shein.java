package company;

import struct.ListNode;

import java.util.Scanner;

/**
 * ACM 模式
 */
@SuppressWarnings("unused")
public class Shein {
    /**
     * n：链表的长度，
     * m：要删除的第 m 个节点
     * <p>
     * 字符串：链表每个元素的值，中间用空格隔开
     */
    public void test() {
        Scanner scanner = new Scanner(System.in);

        String[] condition = scanner.nextLine().split(" ");
        String[] list = scanner.nextLine().split(" ");

        int n = Integer.valueOf(condition[0]), m = Integer.valueOf(condition[1]);

        if (m > n) {
            System.out.println();
            System.exit(0);
        }

        ListNode dummy = new ListNode(), temp = dummy;

        for (String value : list) {
            temp.next = new ListNode(Integer.valueOf(value));
            temp = temp.next;
        }

        temp = dummy;

        for (int i = 1; i < m; i++)
            temp = temp.next;

        temp.next = temp.next.next;

        StringBuilder sb = new StringBuilder();

        temp = dummy.next;

        while (temp != null) {
            sb.append(temp.val).append(" ");
            temp = temp.next;
        }

        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb.toString());
    }

    /**
     * 字符串空格替换为%20
     */
    public String changeSpaceTo20(String str) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                builder.append("%20");
            else
                builder.append(str.charAt(i));
        }

        return builder.toString();
    }
}
