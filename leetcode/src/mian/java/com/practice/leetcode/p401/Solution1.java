package com.practice.leetcode.p401;

import java.util.*;

class Solution1 {
    public List<String> readBinaryWatch(int turnedOn) {
        if (turnedOn == 0) {
            return Collections.singletonList("0:00");
        } else if (turnedOn >= 9) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            int count1 = Integer.bitCount(i);
            for (int j = 0; j < 60; j++) {
                if (count1 + Integer.bitCount(j) == turnedOn) {
                    result.add(i + ":" + (j < 10 ? "0" + j : String.valueOf(j)));
                }
            }
        }
        return result;
    }

    int count1(int num) {
        int count = 0;
        while (num > 0) {
            if (1 == (num & 1)) {
                count ++;
            }
            num >>= 1;
        }
        return count;
    }

    public static void main(String[] argv) {
        Solution1 s = new Solution1();
        List<String> result = s.readBinaryWatch(8);
        System.out.println(result);
    }
}
