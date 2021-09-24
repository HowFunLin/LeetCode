package main.medium;

@SuppressWarnings("unused")
public class FlattenAMultilevelDoublyLinkedList {
    /**
     * 430. 扁平化多级双向链表
     *
     * @param head 位于列表第一级的头节点
     * @return 扁平化列表，使所有结点出现在单级双链表中
     */
    public Node flatten(Node head) {
        Node fake = new Node();
        fake.next = head;

        for (; head != null; head = head.next) {
            if (head.child != null) {
                Node node = head.next, child = head.child;

                head.next = child;
                child.prev = head;
                head.child = null;

                while (child.next != null)
                    child = child.next;

                child.next = node;

                if (node != null)
                    node.prev = child;
            }
        }

        return fake.next;
    }

    /**
     * Definition for a Node.
     */
    private class Node {
        Node prev;
        Node next;
        Node child;
    }
}
