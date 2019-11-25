package com.peter;

import com.peter.leetcode.LongestPrefix;
import com.peter.leetcode.NoRepeatString;
import com.peter.leetcode.StringArrange;

public class Main {

    public static void main(String[] args) {

        String[] testCase1 = new String[]{"flower","flow","flight"};

        String[] testCase2 = new String[]{"dog","racecar","car"};

        String result = LongestPrefix.longestCommonPrefix(testCase1);
        System.out.println("result : " + result);

        System.out.println("result : " + result);
    }
}
