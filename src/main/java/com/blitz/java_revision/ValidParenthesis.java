package com.blitz.java_revision;

import java.util.Stack;

public class ValidParenthesis {
  public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    char[] array = s.toCharArray();

    for (char c : array) {
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        } else {
          char top = stack.pop();
          if ((c == ')' && top != '(') ||
              (c == ']' && top != '[') ||
              (c == '}' && top != '{')) {
            return false;
          }
        }
      }
    }
    return stack.isEmpty();
  }
}
