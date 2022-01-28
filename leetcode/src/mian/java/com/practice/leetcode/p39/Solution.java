package com.practice.leetcode.p39;

import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return new ArrayList<>(innerCombinationSum(candidates, target, 0));
    }


    private Set<List<Integer>> innerCombinationSum(int[] candidates, int target, int i) {
        Set<List<Integer>> result = new HashSet<>();
        if (candidates == null || candidates.length == 0 || target == 0) {
            return result;
        }
        for (;i < candidates.length;i++) {
            int c = candidates[i];
            if ( c < target) {
                Set<List<Integer>> childResult = innerCombinationSum(candidates, target - c, i);
                if (childResult.isEmpty()) {
                    continue;
                }
                childResult.forEach(l -> ((LinkedList) l).addFirst(c));
                result.addAll(childResult);
            } else if (c == target) {
                LinkedList<Integer> linkedList = new LinkedList<>();
                linkedList.add(c);
                result.add(linkedList);
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] argv) {
        Solution s = new Solution();
        List<List<Integer>> result;
//        = s.combinationSum(new int[]{
//                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
//        }, 30);
//        System.out.println(result);
        result = s.combinationSum(new int[]{
                        2,3,6,7
                },
                7
                //        30
        );
        System.out.println(result);
    }
}
