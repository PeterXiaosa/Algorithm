package com.peter.leetcode.tree;

import com.peter.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right,list);
    }
}
