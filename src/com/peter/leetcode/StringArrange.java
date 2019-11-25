package com.peter.leetcode;

import java.util.HashMap;
import java.util.Map;

public class StringArrange {

    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean result = StringArrange.checkInclusion(s1, s2);
        System.out.println("result : " + result);
    }

    /**
     * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
     *
     * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
     *
     * 示例1:
     *
     * 输入: s1 = "ab" s2 = "eidbaooo"
     * 输出: True
     * 解释: s2 包含 s1 的排列之一 ("ba").
     *
     *
     * 示例2:
     *
     * 输入: s1= "ab" s2 = "eidboaoo"
     * 输出: False
     *
     *
     * 注意：
     *
     * 输入的字符串只包含小写字母
     * 两个字符串的长度都在 [1, 10,000] 之间
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }

        char[] charArray = s1.toCharArray();
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        int r = s1.length() - 1;
        int i = 0;

        for (; i <= r; i++) {
            push(map1, s1.charAt(i));
            push(map2, s2.charAt(i));
        }

        i = 0;
        for (;;){
            if (map1.equals(map2)) {
                return true;
            }

            r++;
            if (r == s2.length()) {
                return false;
            }

            push(map2, s2.charAt(r));
            pop(map2, s2.charAt(i));
            i++;
        }
    }

    private static void push(Map<Character, Integer> map, Character character) {
        if (map == null) {
            return;
        }

        if (map.containsKey(character)) {
            map.put(character, map.get(character) + 1);
        }else {
            map.put(character, 1);
        }
    }

    private static void pop(Map<Character, Integer> map, Character character) {
        if (map == null) {
            return;
        }

        if (!map.containsKey(character)){
            return;
        }

        if (map.get(character) == 1) {
            map.remove(character);
        }else {
            map.put(character, map.get(character) - 1);
        }
    }

    // The better method

    /**
     * public boolean checkInclusion(String s1, String s2) {
     *         char[] c1 = s1.toCharArray();
     *         char[] c2 = s2.toCharArray();
     *         int[] used = new int['z' + 1];
     *         Arrays.fill(used, 0);
     *         for (int i = 0; i < c1.length; i++) {
     *             used[c1[i]]++;
     *         }
     *         int start = 0;
     *         for (int i = 0; i < c2.length; i++) {
     *             while (used[c2[i]] == 0) {
     *                 used[c2[start]]++;
     *                 start++;
     *             }
     *             used[c2[i]]--;
     *             if (i - start == c1.length - 1) {
     *                 return true;
     *             }
     *         }
     *         return false;
     *     }
     */
}
