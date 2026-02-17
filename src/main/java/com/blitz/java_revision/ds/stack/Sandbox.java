package com.blitz.java_revision.ds.stack;

import com.blitz.java_revision.ds.stack.*;

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
    System.out.println(stack);
    System.out.println("peek: " + stack.peek());
    System.out.println("pop: " + stack.pop());
    System.out.println("size: " + stack.getSize());
    System.out.println(stack);
    System.out.println("root: " + stack.getRoot());
    System.out.println("tail: " + stack.getTail());
  }
}
