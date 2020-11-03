package dfs;

import base.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用DFS 解决N叉树层序遍历,时间复杂度O(n)，空间复杂度O(n)
 * @author zhanghongjie
 * @date 2020/11/3
 */
public class LevelOrder {
    public List<List<Integer>> solution(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrderCore(root, res, 0);
        return res;
    }

    public void levelOrderCore(Node node, List<List<Integer>> res, int level) {
        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        for (Node child : node.children) {
            levelOrderCore(child, res, level + 1);
        }
    }
}
