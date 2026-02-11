package com.blitz.java_revision.leetcode.medium;

public class NeedleInHaystack {
  public static int findFirstOccurance(String haystack, String needle) {
    if (needle.length() > haystack.length()) {
      return -1;
    }

    if (needle.equals("")) {
      return 0;
    }

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
      if (flag)
        return i; 
    }
    return -1;
  }
}
