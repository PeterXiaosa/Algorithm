package com.peter.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class IPSelector {

    public static void main(String[] args) {
//        List<String> result = restoreIpAddresses("0000");
        getMyIpAddress("", "0000");
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }

    }

    static List<String> res = new ArrayList<>();

    public static List<String> restoreIpAddresses(String s) {

        if(s.length() == 0) {
            return res;
        }
        generateIpAddresses("", s);
        return res;
    }

    /*
     * 在ipAddress中已经存了n - 1个数字和n - 1个点，寻找第n个数字，获得存放了n个数字的ipAddress
     */
    private static void generateIpAddresses(String ipAddress, String s) {
        int n = 0;
        for (int i = 0; i < ipAddress.length(); i++) {
            if(ipAddress.charAt(i) == '.') {
                n++;
            }
        }
        if(n == 3) {
            if(ipAddress.length() - 3 < s.length()) {
                String lastString = s.substring(ipAddress.length() - 3);
                if(lastString.length() >= 4) {
                    return;
                }
                if(lastString.length() != 1 && lastString.charAt(0) == '0') {
                    return;
                }
                if(Integer.valueOf(lastString) >= 0 && Integer.valueOf(lastString) <= 255) {
                    res.add(ipAddress + lastString);
                    return;
                }else {
                    return;
                }
            }else {
                return;
            }
        }
        String[] nextString = new String[3];
        for (int i = 0; i < 3; i++) {
            if(ipAddress.length() - n + i + 1 <= s.length()) {
                nextString[i] = s.substring(ipAddress.length() - n, ipAddress.length() - n + i + 1);
                if(nextString[i].length() != 1 && nextString[i].charAt(0) == '0') {
                    continue;
                }
                if(Integer.valueOf(nextString[i]) >= 0 && Integer.valueOf(nextString[i]) <= 255) {
                    generateIpAddresses(ipAddress + nextString[i] + ".", s);
                }
            }
        }
        return;
    }

    private static void getMyIpAddress(String ipAddress, String s) {
        if (s.length() == 0) {
            return;
        }
        int n = 0;
        for (int i = 0; i < ipAddress.length(); i++) {
            if (ipAddress.charAt(i) =='.') {
                n++;
            }
        }

        if (n == 3) {
            if (ipAddress.length() - 3 < s.length()) {
                String lastString = s.substring(ipAddress.length() - 3);
                if (lastString.length() >= 4) {
                    return;
                }
                if (lastString.length() != 1 && lastString.charAt(0) == '0') {
                    return;
                }
                if (Integer.parseInt(lastString) >= 0 && Integer.parseInt(lastString) <= 255) {
                    res.add(ipAddress + lastString);
                } else {
                    return;
                }
            }
        }

        String[] tempArray = new String[3];
        for (int i = 0; i < 3; i++) {
            if (ipAddress.length() - n + i + 1 <= s.length()) {
//                    String temp = s.substring(ipAddress.length() - n + i + 1);
                tempArray[i] = s.substring(ipAddress.length() - n, ipAddress.length() - n +i +1);
                if (tempArray[i].length() != 1 && tempArray[i].charAt(0) == '0') {
                    continue;
                }
                if (Integer.valueOf(tempArray[i]) >= 0 && Integer.valueOf(tempArray[i]) <= 255) {
                    getMyIpAddress(ipAddress + tempArray[i] + ".", s);
                }
            }
        }
    }
}
