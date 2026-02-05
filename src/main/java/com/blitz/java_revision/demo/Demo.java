package com.blitz.java_revision.demo;

import com.blitz.java_revision.*;

import java.util.Arrays;

public class Demo {
  public static void main(String[] args) {
    int[] arr1 = new int[] {78, 65, 1, 11};
    int[] arr2 = new int[] {999, 666, 333, 11, 75, 63};
    System.out.println(Arrays.toString(TwoUnsortedToOneSorted.twoUnsortedToOneSortedArray(arr1, arr2)));
    System.out.println(ValidParenthesis.isValid("()[]{}"));
    System.out.println(ValidParenthesis.isValid("([)]"));
    System.out.println("two-sum of [2,7,11,15]: " + Arrays.toString(TwoSum.twoSum(new int[] {2,7,11,15}, 9)));
    System.out.println("two-sum of [3, 3] target 6: " + Arrays.toString(TwoSum.twoSum(new int[] {3, 3}, 6)));
    System.out.println("two-sum of [3, 2, 4] target 6: " + Arrays.toString(TwoSum.twoSum(new int[] {3,2,4}, 6)));
    String haystack = "sadbutsad";
    String needle = "sad";
    System.out.println(NeedleInHaystack.findFirstOccurance(haystack, needle));
    haystack = "leetcode";
    needle = "leeto";
    System.out.println(NeedleInHaystack.findFirstOccurance(haystack, needle));
    int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
    System.out.println("sliding window maximum array: " + Arrays.toString(SlidingWindowMaximumArray.slidingWindowMaximumArray(nums, 3)));
    nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
    System.out.println("maximum sum sub-array: " + MaximumSubarray.maximumSumSubarray(nums));
  }
}
