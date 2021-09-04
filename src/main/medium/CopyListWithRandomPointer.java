package main.medium;

import struct.Node;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node cur = head;

        Map<Node, Node> nodeMap = new HashMap<>();

        while (cur != null)
        {
            nodeMap.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;

        while (cur != null)
        {
            nodeMap.get(cur).next = nodeMap.get(cur.next);
            nodeMap.get(cur).random = nodeMap.get(cur.random);
            cur = cur.next;
        }

        return nodeMap.get(head);
    }
}
