package com.blitz.java_revision.leetcode.easy;

import java.util.Arrays;

/* *
 * leetcode 27. Remove Element
 */
public class RemoveElementFromArray {
  public static int removeElement(int[] nums, int val) {
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[count] = nums[i];
        count++;
      }
    }
    System.out.println(Arrays.toString(nums));
    return count;
  }
}
