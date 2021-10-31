package week;

import struct.ListNode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Game_265 {
    /**
     * 5914. 值相等的最小索引
     *
     * @param nums 下标从 0 开始的整数数组 nums
     * @return nums 中满足 i mod 10 == nums[i] 的最小下标 i ；如果不存在这样的下标，返回 -1
     */
    public int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i])
                return i;
        }

        return -1;
    }

    /**
     * <h3>5915. 找出临界点之间的最小和最大距离</h3>
     * 链表中的 临界点 定义为一个 局部极大值点 或 局部极小值点 。
     * <p>如果当前节点的值 严格大于 前一个节点和后一个节点，那么这个节点就是一个  局部极大值点 。</p>
     * 如果当前节点的值 严格小于 前一个节点和后一个节点，那么这个节点就是一个  局部极小值点 。
     * <p>注意：节点只有在同时存在前一个节点和后一个节点的情况下，才能成为一个 局部极大值点 / 极小值点 。</p>
     *
     * @param head 链表 head
     * @return 长度为 2 的数组 [minDistance, maxDistance] ，其中 minDistance 是任意两个不同临界点之间的最小距离，maxDistance 是任意两个不同临界点之间的最大距离。如果临界点少于两个，则返回 [-1，-1]
     */
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return new int[]{-1, -1};

        List<Integer> temp = new ArrayList<>();
        int[] res = new int[2];

        int index = 2;
        while (head.next.next != null) {
            int pre = head.val, cur = head.next.val, next = head.next.next.val;

            if (cur > pre && cur > next)
                temp.add(index);

            if (cur < pre && cur < next)
                temp.add(index);

            head = head.next;
            index++;
        }

        if (temp.size() == 0 || temp.size() == 1)
            return new int[]{-1, -1};

        res[1] = temp.get(temp.size() - 1) - temp.get(0);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < temp.size(); i++) {
            min = Math.min(min, temp.get(i) - temp.get(i - 1));
        }

        res[0] = min;

        return res;
    }
}
