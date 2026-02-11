package com.blitz.java_revision.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class ThreeSum {
  public static List<List<Integer>> threeSum(int[] array, int target) {
    sort(array);
    List<List<Integer>> list = new ArrayList<>();
    for (int i = 0; i < array.length; i++) {
      if (i > 0 && array[i] == array[i - 1])
        continue;
      int left = i + 1;
      int right = array.length - 1;
      
      while (left < right) {
        int sum = array[i] + array[left] + array[right];
        if (sum == target) {
          list.add(List.of(array[i], array[left], array[right]));
          left++;
          right--;

          while (left < right && array[left] == array[left - 1])
            left++;
          while (left < right && array[right] == array[right + 1])
            right--;
        } else if (sum > target) {
          right--;
        } else if (sum < target) {
          left++;
        }
      }
    }

    return list;
  }

  private static void sort(int[] array) {
    sort(array, 0, array.length - 1);
  }

  private static void sort(int[] array, int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;
      sort(array, left, mid);
      sort(array, mid + 1, right);
      merge(array, left, mid, right);
    }
  }

  private static void merge(int[] array, int left, int mid, int right) {
    int[] leftArr = new int[mid - left + 1];
    for (int i = 0; i < leftArr.length; i++)
      leftArr[i] = array[left + i];
    
    int[] rightArr = new int[right - mid];
    for (int i = 0; i < rightArr.length; i++)
      rightArr[i] = array[mid + 1 + i];

    int x = 0;
    int y = 0;
    int z = left;

    while (x < leftArr.length && y < rightArr.length)
      if (leftArr[x] < rightArr[y])
        array[z++] = leftArr[x++];
      else
        array[z++] = rightArr[y++];
    
    while (x < leftArr.length)
      array[z++] = leftArr[x++];

    while (y < rightArr.length)
      array[z++] = rightArr[y++];
  }
}
