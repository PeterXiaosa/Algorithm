package com.peter.leetcode.tree;

import com.peter.leetcode.util.TreeNode;

/**
 * //给出一个完全二叉树，求出该树的节点个数。
 * //
 * // 说明：
 * //
 * // 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为
 * //第 h 层，则该层包含 1~ 2h 个节点。
 * //
 * // 示例:
 * //
 * // 输入:
 * //    1
 * //   / \
 * //  2   3
 * // / \  /
 * //4  5 6
 * //
 * //输出: 6
 */

public class CountNodes_222 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return  0;
        }

        int leftLevel = getTreeLevel(root.left);
        int rightLevel = getTreeLevel(root.right);
        if (leftLevel == rightLevel) {
            return ((1 << leftLevel)-1) + countNodes(root.right) + 1;
        } else {
            return ((1 << rightLevel) -1) + countNodes(root.left) + 1;
        }
    }

    private int getTreeLevel(TreeNode node) {
        TreeNode treeNode = node;
        int level = 0;
        while (treeNode != null) {
            treeNode = treeNode.left;
            level++;
        }
        return level;
    }
}
