package com.blitz.java_revision.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public static int[] twoSum(int[] array, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < array.length; i++) {
      int difference = target - array[i];
      if (map.containsKey(difference)) {
        return new int[] {i, map.get(difference)};
      }
      map.put(array[i], i);
    }
    return new int[] {-1, -1};
  }
}
