package com.peter.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *
 *
 * 说明：
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class Intersection {


    public int[] intersection(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        int[] num3;
        if (length1 > length2) {
            num3 = nums1;
            nums1 = nums2;
            nums2 = num3;
        }
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        length1 = nums1.length;
        length2 = nums2.length;

        while (i < length1 && j < length2) {
            if (nums1[i] == nums2[j]) {
                if (!list.contains(nums1[i])) {
                    list.add(nums1[i]);
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] res = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }

        return res;
    }
}
