package base;

import java.util.List;

/**
 * @author zhanghongjie
 * @date 2020/11/3
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
