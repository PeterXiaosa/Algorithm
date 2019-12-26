package com.peter.leetcode.string;

public class StringMulti {

    public static void main(String[] args) {
        System.out.println("result : " + myMultiply("123", "4567"));
    }

    /**
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     *
     * 示例 1:
     *
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     * 示例 2:
     *
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     * 说明：
     *
     * num1 和 num2 的长度小于110。
     * num1 和 num2 只包含数字 0-9。
     * num1 和 num2 均不以零开头，除非是数字 0 本身。
     * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
     * @param num1 input1
     * @param num2 input2
     * @return
     */

    public static String multiplyD(String num1, String num2) {
        int len1, len2, carry = 0;
        StringBuilder result = new StringBuilder();
        len1 = num1.length();
        len2 = num2.length();
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        for (int i = 0;i < len1 + len2; ++i){//得到第i位数是多少，并存储进字符串
            int temp = 0;
            for (int j = 0,k = i - j; j < len1 && k >= 0; ++j, --k){//计算第i位上面的基数为所有下标和为i的两个数的积的和
                if (k < len2)
                    temp += (num1.charAt(j) - '0') * (num2.charAt(k) - '0');
            }
            result.append((char)((temp + carry)%10 + '0'));
            carry = (temp + carry)/10;
        }

        if (carry > 0){
            result.append((char)(carry + '0'));
        }
        String str = result.reverse().toString().replaceAll("^(0+)", "");//去掉字符串前面的'0

        if (str.length() == 0)
            return "0";
        else
            return str;
    }

    public static String multiplyB(String num1, String num2) {
        // int m=num1.length();
        // int n=num2.length();
        int[] res=new int[num1.length()+num2.length()];
        char[] a1=num1.toCharArray();
        char[] a2=num2.toCharArray();
        for(int i=num1.length()-1;i>=0;i--){
            int n1=(int)(a1[i]-'0');
            for(int j=num2.length()-1;j>=0;j--){
                int n2=(int)(a2[j]-'0');
                res[i+j+1]+=n1*n2;
            }
        }
        int carry=0;
        for(int i=res.length-1;i>=0;i--){
            res[i]+=carry;
            carry=res[i]/10;
            res[i]=res[i]%10;
        }
        StringBuilder sb=new StringBuilder();
        for(int i:res){
            sb.append(i);
        }
        String result=sb.toString();
        while(result.length()>0 && result.charAt(0) == '0'){  //当结果长度大于0，且第一位为0，将0删除
            result = result.substring(1);
        }
        return result.length()>0?result:"0";


    }

    public static String myMultiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        char[] array1 = num1.toCharArray();
        char[] array2 = num2.toCharArray();
        for (int i = array1.length -1; i >=0; i--) {
            int n1 = array1[i] - '0';
            for (int j = array2.length - 1; j >= 0; j--) {
                int n2 = array2[j] - '0';
                res[i + j +1] += n1 * n2;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int a = res.length -1; a >= 0; a--) {
            int unit = res[a] % 10;
            int decade = res[a] / 10;
            builder.insert(0, unit);
            if (a > 0) {
                res[a - 1] += decade;
            }
        }
        String temp = builder.toString();
        if (temp.length() > 0 && temp.charAt(0) == '0') {
            temp = temp.substring(1);
        }
        return temp;
    }
}
