package com.blitz.java_revision;

import java.util.stream.IntStream;

public class TwoUnsortedToOneSorted {

  public static int[] twoUnsortedToOneSortedArray(int[] arr1, int[] arr2) {
    int[] array = IntStream.concat(IntStream.of(arr1), IntStream.of(arr2))
      .toArray();
    return sort(array);
  }

  private static int[] sort(int[] array) {
    mergeSort(array, 0, array.length - 1);
    return array;
  }

  private static int[] mergeSort(int[] array, int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;
      mergeSort(array, left, mid);
      mergeSort(array, mid + 1, right);
      merge(array, left, mid, right);
    }
    return array;
  }

  private static void merge(int[] array, int left, int mid, int right) {
    int[] leftArr = new int[mid - left + 1];
    for (int i = 0; i < leftArr.length; i++) {
      leftArr[i] = array[left + i];
    }

    int[] rightArr = new int[right - mid];
    for (int i = 0; i < rightArr.length; i++) {
      rightArr[i] = array[mid + 1 + i];
    }

    int x = 0;
    int y = 0;
    int z = left;

    while (x < leftArr.length && y < rightArr.length) {
      if (leftArr[x] < rightArr[y]) {
        array[z] = leftArr[x];
        z++;
        x++;
      } else {
        array[z++] = rightArr[y++];
      }
    }

    while (x < leftArr.length)
      array[z++] = leftArr[x++];

    while (y < rightArr.length)
      array[z++] = rightArr[y++];
  }
}
