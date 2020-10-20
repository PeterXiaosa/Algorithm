package com.peter;

import com.peter.leetcode.listnode.reorderList;
import com.peter.leetcode.util.CommonUtil;
import com.peter.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static abstract class Human{}

    static class Man extends Human{}

    static class Woman extends Human{}

    public void sayHello(Human guy) {
        System.out.println("hello, guy!");
    }

    public void sayHello(Man guy) {
        System.out.println("hello, man!");
    }

    public void sayHello(Woman guy) {
        System.out.println("hello, woman!");
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        ListNode listNode = CommonUtil.createListNode(list);
        reorderList reorderList = new reorderList();
        reorderList.reorderList(listNode);
        System.out.println("s");
    }
}
