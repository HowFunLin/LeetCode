package main.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = nums2.length - 1; i >= 0; i--)
        {
            map.put(nums2[i], i);

            while (!stack.isEmpty() && stack.peek() < nums2[i])
                stack.pop();

            int pos = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
            nums2[i] = pos;
        }

        for (int i = 0; i < nums1.length; i++)
        {
            nums1[i] = nums2[map.get(nums1[i])];
        }

        return nums1;
    }
}
