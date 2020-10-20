package com.peter.leetcode.util;

import java.util.List;

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
}
