package com.practice.leetcode.p1;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (nums != null && nums.length > 1) {
            Set<Integer> numsSet = new HashSet<>();
            for (int num : nums) {
                if (numsSet.contains(num)) {
                    result[0] = num;
                    result[1] = target - num;
                } else {
                    numsSet.add(target - num);
                }
            }
        }
        return result;
    }


    public static void main(String[] argv) {
        
    }
}
