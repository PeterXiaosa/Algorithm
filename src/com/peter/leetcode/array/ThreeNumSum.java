package com.peter.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  三数之和
 *
 *  给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeNumSum {

    private static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{};
        List<List<Integer>> result = threeSum(nums);
        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(" " + integer);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < length -2; i++) {
            temp.add(nums[i]);
            for (int j = i + 1; j < length - 1; j++) {
                temp.add(nums[j]);
                for (int k = j + 1; k <length; k++) {
                    if (isContains(res, temp)) {
                        continue;
                    }
                    if (temp.get(0) + temp.get(1) + nums[k] == 0) {
                        temp.add(nums[k]);
                        res.add(new ArrayList<>(temp));
                        temp.remove(2);
                    }
                }
                temp.remove(1);
            }
            temp.remove(0);
        }
        return res;
    }

    private static boolean isContains(List<List<Integer> > list, List<Integer> temp) {
        for (List<Integer> childRes : list) {
            if (childRes.contains(temp.get(0)) && childRes.contains(temp.get(1))) {
                return true;
            }
        }
        return false;
    }

    public static List<List<Integer>> answer1(int [] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0;i < nums.length - 2;i ++){
            //当第i个数开始大于零时，跳出循环
            if(nums[i] > 0)
                break;
            //当相邻数相等时，跳过该数，避免重复结果
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            //使用两个指针，向中间夹
            int left = i+1,right = nums.length-1,sum = -nums[i];
            while(left < right){
                int count = nums[left] + nums[right];
                if(count == sum){
                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left < right && nums[left] == nums[left+1]) left++;
                    while (left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }else if(count < sum){
                    left ++;
                }else {
                    right --;
                }
            }
        }
        return list;
    }

    public static List<List<Integer>> answer2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i -1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            int sum = -nums[i];
            while (left < right) {
                int count = nums[left] + nums[right];
                if (sum == count) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                } else if (count > sum) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
