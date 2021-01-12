package com.peter.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class KClosest {

    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] * o1[0] + o1[1] * o1[1] - (o2[0] * o2[0] + o2[1] * o2[1]);
            }
        });
        int[][] res = new int[K][2];
        System.arraycopy(points, 0, res, 0, K);
        return res;
    }

}
