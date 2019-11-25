package com.peter.leetcode;

public class LongestPrefix {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     *
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     *
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     */


    /**
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        String firstStr = strs[0];
        int firstStrLength = firstStr.length();
        boolean isNeedExit = false;
        StringBuilder result = new StringBuilder();

        for (int j = 0; j < firstStrLength; j++) {
            char prefix = firstStr.charAt(j);
            for (int i = 1; i < strs.length; i++) {
                String str = strs[i];
                if (j >= str.length()) {
                    isNeedExit = true;
                    break;
                }

                if (str.charAt(j) != prefix) {
                    isNeedExit = true;
                    break;
                }
            }
            if (isNeedExit) {
                break;
            }
            result.append(prefix);
        }

        return result.toString();
    }

    /**
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        String firstStr = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(firstStr) != 0) {
                firstStr = firstStr.substring(0, firstStr.length() - 1);
                if (firstStr.isEmpty()) {
                    return "";
                }
            }
        }
        return firstStr;
    }
}
