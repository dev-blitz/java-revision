package com.blitz.java_revision.leetcode.medium;

public class Reverse {
  public static int reverseInt(int x) {
    int reverse = 0;
    int sign = x > 0 ? 1 : -1;
    if (x < 0) 
      x = sign * x;
    while (x > 0) {
      int remainder = x % 10;
      reverse = reverse * 10 + remainder;
      x = x / 10;
    }
    return sign * reverse;
  }

  public static int reverseIntFaster(int x) {
    int sign = x > 0 ? 1 : -1;
    char[] original = String.valueOf(sign * x).toCharArray();
    char[] reverse = new char[original.length];
    
    for (int i = 0; i < reverse.length; i++)
      reverse[i] = original[original.length - 1 - i];

    return sign * Integer.parseInt(String.valueOf(reverse));
  }

  public static String reverseString(String str) {
    char[] array = str.toCharArray();
    char[] reverse = new char[array.length];

    for (int i = 0; i < reverse.length; i++)
      reverse[i] = array[array.length - 1 - i];

    return String.valueOf(reverse);
  }
}
