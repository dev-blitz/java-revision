package com.blitz.java_revision.leetcode.medium;

public class MaximumSumSubarray {
  public static int maximumSumSubarray(int[] nums) {
    int currentSum = nums[0];
    int max = nums[0];

    for (int i = 1; i < nums.length; i++) {
      currentSum = nums[i] > (currentSum + nums[i]) ? nums[i] : currentSum + nums[i];
      max = max > currentSum ? max : currentSum;
    }

    return max;
  }
}
