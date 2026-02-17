package com.blitz.java_revision.code_demo;

import com.blitz.java_revision.leetcode.medium.*;
import com.blitz.java_revision.leetcode.easy.*;
import java.util.Arrays;

public class Demo {
  public static void main(String[] args) {
    int[] arr1 = new int[] {78, 65, 1, 11};
    int[] arr2 = new int[] {999, 666, 333, 11, 75, 63};
    System.out.println(Arrays.toString(TwoUnsortedToOneSorted.twoUnsortedToOneSortedArray(arr1, arr2)));
    System.out.println(ValidParenthesis.isValid("()[]{}"));
    System.out.println(ValidParenthesis.isValid("([)]"));
    System.out.println("two-sum of [2,7,11,15]: " + Arrays.toString(com.blitz.java_revision.leetcode.medium.TwoSum.twoSum(new int[] {2,7,11,15}, 9)));
    System.out.println("two-sum of [3, 3] target 6: " + Arrays.toString(com.blitz.java_revision.leetcode.medium.TwoSum.twoSum(new int[] {3, 3}, 6)));
    System.out.println("two-sum of [3, 2, 4] target 6: " + Arrays.toString(com.blitz.java_revision.leetcode.medium.TwoSum.twoSum(new int[] {3,2,4}, 6)));
    String haystack = "sadbutsad";
    String needle = "sad";
    System.out.println(NeedleInHaystack.findFirstOccurance(haystack, needle));
    haystack = "leetcode";
    needle = "leeto";
    System.out.println(NeedleInHaystack.findFirstOccurance(haystack, needle));
    int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
    System.out.println("sliding window maximum array: " + Arrays.toString(SlidingWindowMaximumArray.slidingWindowMaximumArray(nums, 3)));
    nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
    System.out.println("maximum sum sub-array: " + MaximumSumSubarray.maximumSumSubarray(nums));

    System.out.println("Longest Substring Without Repeating Characters: " + (LongestSubstringWithoutRepeatingCharacters.longestSubstringWithoutRepeatingCharacters("abcabcbb")));
    System.out.println("Longest Substring Without Repeating Characters: " + (LongestSubstringWithoutRepeatingCharacters.longestSubstringWithoutRepeatingCharacters("pwwkew")));
    System.out.println("reverse of -123: " + Reverse.reverseInt(-123));
    System.out.println("reverse of -123: " + Reverse.reverseIntFaster(-123));
    System.out.println();
    int[] array = new int[] {-1,0,1,2,-1,-4};
    System.out.println("three sum for the sum 0 of array: " + Arrays.toString(array) + "\n\tare: " + ThreeSum.threeSum(array, 0));
    nums = new int[] {2,7,11,15};
    int target = 9;
    System.out.println("two-sum for " + Arrays.toString(nums) + ":\n\t\t" + 
        Arrays.toString(com.blitz.java_revision.leetcode.easy.TwoSum.twoSum(nums, target)));
    nums = new int[] {1,3,5,6};
    target = 5;
    System.out.println("index where " + target + "should be inserted: " + SearchInsert.searchInsert(nums, target));
  }
}
