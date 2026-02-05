package com.blitz.java_revision;

public class NeedleInHaystack {
  public static int findFirstOccurance(String haystack, String needle) {
    char[] hArr = haystack.toCharArray();
    char[] nArr = needle.toCharArray();

    for (int i = 0; i < hArr.length; i++) {
      int ans = i;
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
        return ans; 
    }
    return -1;
  }
}
