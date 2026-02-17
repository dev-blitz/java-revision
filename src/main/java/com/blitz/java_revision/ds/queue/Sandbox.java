package com.blitz.java_revision.ds.queue;

public class Sandbox {
  public static void main(String[] args) {
    Queue queue = new Queue();
    queue.offer(0);
    queue.offer(1);
    queue.offer(2);
    queue.offer(3);
    System.out.println("size: " + queue.getSize());
    System.out.println("root: " + queue.getRoot());
    System.out.println("tail: " + queue.getTail());
    System.out.println(queue);
    System.out.println("peek: " + queue.peek());
    System.out.println("poll: " + queue.poll());
    System.out.println("size: " + queue.getSize());
    System.out.println(queue);
    System.out.println("root: " + queue.getRoot());
    System.out.println("tail: " + queue.getTail());
  }
}
