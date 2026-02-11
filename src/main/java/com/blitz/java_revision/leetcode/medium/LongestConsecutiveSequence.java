package com.blitz.java_revision.leetcode.medium;

import java.util.Arrays;

public class LongestConsecutiveSequence {
  public static int longestConsecutiveSequence(int[] nums) {
    Arrays.sort(nums);
    int current = 1;
    int longest = 1;
    int start = 0;
    int last = 0;

    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i + 1] - nums[i] == 1) {
        current++;
        last++;
     } else if (nums[i + 1] == nums[i]) {
       last++; 
     } else {
        longest = longest > current ? longest : current;
        if (current > longest) {
          longest = current;
          start = i;
        }
        current = 1;
      }
    }
    System.out.println(Arrays.toString(Arrays.copyOfRange(nums, start, last)));
    return longest;
  }
}
