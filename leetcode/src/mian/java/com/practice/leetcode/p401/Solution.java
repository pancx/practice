package com.practice.leetcode.p401;

import java.util.*;

class Solution {
    private final Map<Integer, List<String>> hourMap = new HashMap<>();
    private final Map<Integer, List<String>> minuteMap = new HashMap<>();

    public List<String> readBinaryWatch(int turnedOn) {
        if (turnedOn == 0) {
            return Collections.singletonList("0:00");
        } else if (turnedOn >= 9) {
            return Collections.emptyList();
        }

        for (int i = 0; i < 12; i++) {
            int count1 = count1(i);
            if (hourMap.containsKey(count1)) {
                hourMap.get(count1).add(String.valueOf(i));
            } else {
                List<String> rList = new ArrayList<>();
                rList.add(String.valueOf(i));
                hourMap.put(count1, rList);
            }
        }

        for (int i = 0; i < 60; i++) {
            int count1 = count1(i);
            String vStr = i < 10? "0" + i : String.valueOf(i);
            if (minuteMap.containsKey(count1)) {
                minuteMap.get(count1).add(vStr);
            } else {
                List<String> rList = new ArrayList<>();
                rList.add(vStr);
                minuteMap.put(count1, rList);
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i <= turnedOn; i++) {
            int j = turnedOn - i;
            if (hourMap.containsKey(i) && minuteMap.containsKey(j)) {
                hourMap.get(i).forEach(hour -> minuteMap.get(j).forEach(minute -> result.add(hour + ":" + minute)));
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
    
    static {
//        hourMap.put(0, Collections.singletonList("0"));
//        hourMap.put(1, Arrays.asList("1", "2", "4", "8"));
//        hourMap.put(2, Arrays.asList("3", "5", "9", "6", "10"));
//        hourMap.put(3, Arrays.asList("7", "11"));
//
//        minuteMap.put(0, Collections.singletonList("00"));
//        minuteMap.put(1, Arrays.asList("01", "02", "04", "08", "16", "32"));
//        minuteMap.put(2, Arrays.asList("03", "05", "09", "17", "33", "06", "10", "18", "34",
//                "12", "20", "36", "24", "40", "48"));
//        minuteMap.put(3, Arrays.asList("07", "11", "19", "35", "14", "22", "38", "28", "44", "56", "13", "21", "37", "25", "41"));
//        minuteMap.put(4, Arrays.asList("15", "23", "39", "27", "43", "51", ""));
//        minuteMap.put(5, Arrays.asList("31", "47"));
    }

    public static void main(String[] argv) {
        Solution s = new Solution();
        List<String> result = s.readBinaryWatch(8);
        System.out.println(result);
    }
}
