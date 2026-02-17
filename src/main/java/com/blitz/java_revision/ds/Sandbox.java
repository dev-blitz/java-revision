package com.blitz.java_revision.ds;

import com.blitz.java_revision.ds.*;

public class Sandbox {
  public static void main(String[] args) {
    Stack stack = new Stack();
    stack.push(0);
    stack.push(1);
    stack.push(2);
    stack.push(3);
    System.out.println("size: " + stack.getSize());
    System.out.println("root: " + stack.getRoot());
    System.out.println("tail: " + stack.getTail());
    stack.print();
    System.out.println(stack);
  }
}
