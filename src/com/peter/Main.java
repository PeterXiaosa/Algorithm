package com.peter;

import com.peter.leetcode.LongestPrefix;
import com.peter.leetcode.NoRepeatString;

public class Main {

    public static void main(String[] args) {

        String[] testCase1 = new String[]{"flower","flow","flight"};

        String[] testCase2 = new String[]{"dog","racecar","car"};

        String result = LongestPrefix.longestCommonPrefix(testCase1);
        System.out.println("result : " + result);

        result = LongestPrefix.longestCommonPrefix(testCase2);
        System.out.println("result : " + result);
    }
}
