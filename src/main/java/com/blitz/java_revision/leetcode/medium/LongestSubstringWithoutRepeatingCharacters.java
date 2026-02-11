package com.blitz.java_revision.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
  public static int longestSubstringWithoutRepeatingCharacters(String s) {
    Set<Character> set = new HashSet<Character>();
    int max = 0;
    int left = 0;

    for (int right = 0; right < s.length(); right++) {
      char c = s.charAt(right);
      while (set.contains(c))
          set.remove(s.charAt(left++));
      set.add(c);
      max = max > (right - left + 1) ? max : (right - left + 1);
    }
    return max;
  }
}
