package com.peter.leetcode.util;

import java.util.*;

public class CommonUtil {

    public static ListNode createListNode(List<Integer> list) {
        ListNode result = new ListNode();
        ListNode pre = result;
        for (int i =0; i < list.size(); i++) {
            result.next = new ListNode(list.get(i));
            result = result.next;
        }
        return pre.next;
    }

    static int counter = 0;

    public static TreeNode createTreeNode(int[] array) {
        Queue<TreeNode> queue = new LinkedList<>();

        int index = 1;
        TreeNode head = new TreeNode(array[0]);
        queue.offer(head);

        while (index < array.length) {
            TreeNode parent = queue.poll();

            int left = array[index++];
            if (left == 0) {
                parent.left = null;
            } else {
                parent.left = new TreeNode(left);
                queue.offer(parent.left);
            }

            if (index >= array.length) {
                break;
            }
            int right = array[index++];
            if (right == 0) {
                parent.right = null;
            } else {
                parent.right = new TreeNode(right);
                queue.offer(parent.right);
            }
        }

        return head;
    }

}
