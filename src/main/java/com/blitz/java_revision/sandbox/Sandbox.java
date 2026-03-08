package com.blitz.java_revision.sandbox;

import java.util.Arrays;
import java.util.stream.*;

import com.blitz.java_revision.leetcode.easy.*;

public class Sandbox {
  public static void main(String[] args) {
    int[] arr = new int[] {1, 5, 3, 9, 5, 2, 10, 1};
    Arrays.sort(arr);
    System.out.println("original array: " + Arrays.toString(arr));
    System.out.println("without duplicates: " + RemoveDuplicates.removeDuplicates(arr));
  }
}
