package com.blitz.java_revision;

import java.util.stream.IntStream;

public class SlidingWindowMaximumArray {
  public static int[] slidingWindowMaximumArray(int[] nums, int k) {
    int[] output = new int[nums.length - k + 1];
    int[] window;
    for (int i = 0; i < output.length; i++) {
      window = new int[k];
      for (int j = 0; j < window.length; j++) {
        window[j] = nums[i + j];
      }
      output[i] = findMax(window); 
    }
    return output;
  }

  private static int findMax(int[] nums) {
    return IntStream.of(nums)
      .max()
      .getAsInt();
  }
}
