package bfs;

import base.Node;

import java.util.*;

/**
 * bfs 层序遍历 N叉树
 * @author zhanghongjie
 * @date 2020/11/3
 */
public class LevelOrder {
    public List<List<Integer>> solution(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node n = queue.poll();
                level.add(n.val);
                queue.addAll(n.children);
            }
            res.add(level);
        }
        return res;
    }

    public List<List<Integer>> solution2(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        List<Node> previousLayer = Arrays.asList(root);
        while (!previousLayer.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            List<Node> currentLayer = new ArrayList<>();
            for (Node n : previousLayer) {
                level.add(n.val);
                currentLayer.addAll(n.children);
            }
            res.add(level);
            previousLayer = currentLayer;
        }
        return res;
    }
}
