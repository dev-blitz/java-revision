package com.blitz.java_revision.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for the Two Sum problem.
 * * <p>This implementation uses a {@link java.util.HashMap} to achieve 
 * linear time complexity {@code O(n)}.</p>
 * * @see <a href="https://leetcode.com/problems/two-sum/">LeetCode Problem Link</a>
 * @author blitz
 */
public class TwoSum {
  
  /**
   * Finds two indices such that the values at those indices sum to the target.
   * * @param array  The input array of integers.
   * @param target The integer value to reach.
   * @return An array containing the two indices, or {@code [-1, -1]} if 
   * no solution exists.
   */
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
