package com.peter.leetcode.string;

import java.util.Stack;

public class ReverseString {

    public static void main(String[] args) {
        System.out.println("result :" + standerReverseWords("  hello world!    "));
    }

    /**
     *  给定一个字符串，逐个翻转字符串中的每个单词。
     *
     *  
     *
     * 示例 1：
     *
     * 输入: "the sky is blue"
     * 输出: "blue is sky the"
     * 示例 2：
     *
     * 输入: "  hello world!  "
     * 输出: "world! hello"
     * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 示例 3：
     *
     * 输入: "a good   example"
     * 输出: "example good a"
     * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     *  
     *
     * 说明：
     *
     * 无空格字符构成一个单词。
     * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s input
     * @return
     */

    public static String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp != ' ' && i != s.length() - 1) {
                builder.append(temp);
            } else if (temp != ' ') {
                builder.append(temp);
                stack.push(builder.toString());
            }else {
                String tempStr = builder.toString();
                if (!tempStr.isEmpty()) {
                    stack.push(tempStr);
                }
                builder.delete(0, tempStr.length());
            }
        }

        builder.delete(0, builder.length());
        int size = stack.size();
        for (int j =0; j < size; j++) {
            String str = stack.pop();
            if (!str.isEmpty()) {
                builder.append(str);
            }
            if (j != size - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    public static String standerReverseWords(String s) {
        if(s == null || s.length()==0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String[] strs = s.trim().split(" ");
        for(int i=strs.length-1; i>=0; i--) {
            if(strs[i].length()==0) {
                continue;
            }
            sb.append(strs[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
