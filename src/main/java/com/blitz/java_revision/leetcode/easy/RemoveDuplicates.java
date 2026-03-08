package com.blitz.java_revision.leetcode.easy;

import java.util.Arrays;

/**
 * remove duplicates problem in leetcode easy 
 * @see <a href="https://leetcode.com/problems/two-sum/">LeetCode Problem Link</a>
 * @author blitz
 */
public class RemoveDuplicates {

  /**
   * returns the size of elements any duplicates
   * @param array array wothout duplicates
   * @return total number of elements without duplicates
   */
  public static int removeDuplicates(int[] array) {
    int k = 1; // assuming one element without duplicates
    for (int i = 0; i < array.length; i++) {
      if (array[k-1] != array[i]) { // assuming the array is sorted condition is applied
        array[k] = array[i];
        k++; // k increments
      }
    }

    System.out.println(Arrays.toString(array));
    return k;
  }
}
