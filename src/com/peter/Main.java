package com.peter;

import com.peter.leetcode.util.CommonUtil;
import com.peter.leetcode.util.TreeNode;
import com.sun.org.apache.xalan.internal.xsltc.dom.MatchingIterator;

import java.util.*;
import java.util.spi.CalendarDataProvider;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{7,6,4,3,1};
//        TreeNode root = CommonUtil.createTreeNode(array);

        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        new Main().rotate(matrix);

        String s = getToString(65538);
        System.out.print(s);
    }

    private static String getToString(int i) {
        String s ="";
        while (i >0) {
            s+= "s";
            i--;
        }
        return s;
    }

//    public void rotate(int[][] matrix) {
//        if(matrix.length == 0 || matrix.length != matrix[0].length) {
//            return;
//        }
//        int nums = matrix.length;
//        int times = 0;
//        while(times <= (nums >> 1)){
//            int len = nums - (times << 1);
//            for(int i = 0; i < len - 1; ++i){
//                int temp = matrix[times][times + i];
//                matrix[times][times + i] = matrix[times + len - i - 1][times];
//                matrix[times + len - i - 1][times] = matrix[times + len - 1][times + len - i - 1];
//                matrix[times + len - 1][times + len - i - 1] = matrix[times + i][times + len - 1];
//                matrix[times + i][times + len - 1] = temp;
//            }
//            ++times;
//        }
//    }


    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n < 2) return;

        int start = 0;
        int end = n-1;

        //  依次将最外环的列旋转
        while (start < end) {
            rotate(matrix, start, end);
            start++;
            end--;
        }
    }

    public void rotate(int[][] matrix, int start, int end) {
        // 先存储最上面一行数据
        int[] temp = Arrays.copyOfRange(matrix[start], start, end + 1);

        for (int i = start; i < end; i++) {
            // 左侧一列替换顶部一行
             matrix[start][end - i]=matrix[i][start];
            // 底部一行替换左侧一列
            matrix[i][start] = matrix[end][i];
            // 右侧一列替换底部一行
            matrix[end][i] = matrix[end - i][end];
            // 存储的顶部一行替换右侧一列
            matrix[i][end] = temp[i - start];
        }
    }
}
