package struct;

import java.util.List;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node random;
    public List<Node> children;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
