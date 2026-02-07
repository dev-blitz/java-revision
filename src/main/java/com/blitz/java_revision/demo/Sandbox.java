package com.blitz.java_revision.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Sandbox {
  private static int longestSubstringWithoutRepeating(String s) {
    int left = 0;
    int max = 0;
    Set<Character> set = new HashSet<Character>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      while (set.contains(c)) {
        set.remove(s.charAt(left));
        left++;
      }
      set.add(c);
      max = max > i - left + 1 ? max : i - left + 1;
    }
    return max;
  }

  private static boolean validParenthesis(String str) {
    Stack<Character> stack = new Stack<>();

    for (char c : str.toCharArray()) {
      if (c == '(' || c == '[' || c == '{') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        }

        char top = stack.pop();
        if ((c == ')' && top != '(') ||
            (c == ']' && top != '[') ||
            (c == '}' && top != '{')) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }

  private static int needleInHaystack(String haystack, String needle) {
    char[] hArr = haystack.toCharArray();
    char[] nArr = needle.toCharArray();

    for (int i = 0; i <= hArr.length - nArr.length; i++) {
      boolean flag = false;
      for (int j = 0; j < nArr.length; j++) {
        if (hArr[i + j] == nArr[j]) {
          flag = true;
        } else {
          flag = false;
          break;
        }
      }
      if (flag) {
        return i;
      }
    }
    return -1;
  }

  private static int maximumSubarray(int[] nums) {
    int max = nums[0];
    int currentMax = max;
    int startIndex = 0;
    int temp = 0;
    int lastIndex = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > currentMax + nums[i]) {
        currentMax = nums[i];
        temp = i;
      } else {
        currentMax += nums[i];
      }
      if (currentMax > max) {
        max = currentMax;
        startIndex = temp;
        lastIndex = i;
      }
    }
    System.out.println("sub-array: " + Arrays.toString(Arrays.copyOfRange(nums, startIndex, lastIndex)));
    return max;
  }

  private static int[] slidingWindow(int[] nums, int k) {
    int[] output = new int[nums.length - k + 1];
    int[][] result = new int[output.length][k];
    for (int i = 0; i < output.length; i++) {
      int[] window = new int[k];
      for (int j = 0; j < window.length; j++) {
        window[j] = nums[i + j];
      }
      result[i] = window;
      output[i] = max(window);
    }
    System.out.println(Arrays.deepToString(result));
    return output;
  }

  public static int max(int[] array) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < array.length; i++)
      max = max > array[i] ? max : array[i];
    return max;
  }

  public static void main(String[] args) {
    System.out.println("sliding-window: " + Arrays.toString(slidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
    System.out.println("maximum-sub-array: " + maximumSubarray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    System.out.println("needle in haystack: " + needleInHaystack("itoldsadbuttrue", "sad"));
    String parenthesis = "(]";
    System.out.println("valid-parenthesis for " + parenthesis + ": " + validParenthesis(parenthesis));
    parenthesis = "{[)(]}";
    System.out.println("valid-parenthesis for " + parenthesis + ": " + validParenthesis(parenthesis));
    parenthesis = "{[()()]}";
    System.out.println("valid-parenthesis for " + parenthesis + ": " + validParenthesis(parenthesis));
    char[] cArr = new char[7];
    System.out.println(Arrays.toString(cArr));
  }
}
