package com.blitz.java_revision.leetcode.easy;

import java.util.Arrays;

public class RemoveDuplicates {
  public static int removeDuplicates(int[] array) {
    int k = 1;
    for (int i = 0; i < array.length; i++) {
      if (array[k-1] != array[i]) {
        array[k] = array[i];
        k++;
      }
    }

    System.out.println(Arrays.toString(array));
    return k;
  }
}
