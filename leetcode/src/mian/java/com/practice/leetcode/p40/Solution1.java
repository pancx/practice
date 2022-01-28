package com.practice.leetcode.p40;

import java.util.*;

class Solution1 {
    
    private Set<List<Integer>> tried = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> result = new HashSet<>();
        innerCombinationSum(candidates, target, 0, result, new ArrayList<>());
        return new ArrayList<>(result);
    }


    private void innerCombinationSum(int[] candidates, int target, int i, Set<List<Integer>> result, List<Integer> tmpResult) {
        if (candidates == null || candidates.length == 0 || target == 0) {
            tmpResult.clear();
            return;
        }
        for (;i < candidates.length;i++) {
            int c = candidates[i];
            if ( c < target) {
                tmpResult.add(c);
                if (!tried.contains(tmpResult)) {
                    tried.add(new ArrayList<>(tmpResult));
                    innerCombinationSum(candidates, target - c, i + 1, result, tmpResult);
                }
                tmpResult.remove(tmpResult.size() - 1);
            } else if (c == target) {
                tmpResult.add(c);
                result.add(new ArrayList<>(tmpResult));
                tmpResult.remove(tmpResult.size() - 1);
            } else {
                break;
            }
        }
    }

    public static void main(String[] argv) {
        Solution1 s = new Solution1();
        List<List<Integer>> result = s.combinationSum2(new int[]{
//                10, 1, 2, 7, 6, 1, 5
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
        }, 
        //        8
                30
        );
        System.out.println(result);
        result = s.combinationSum2(new int[]{
                        2,3,6,7
                },
                7
                //        30
        );
        System.out.println(result);
    }
}
