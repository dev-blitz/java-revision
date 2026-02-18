package com.blitz.java_revision.ds.dequeue;

public class Sandbox {
  public static void main(String[] args) {
    Dequeue dequeue = new Dequeue();
    dequeue.offer(0);
    dequeue.offer(1);
    dequeue.offer(2);
    dequeue.offer(3);
    System.out.println("size: " + dequeue.getSize());
    System.out.println("root: " + dequeue.getRoot());
    System.out.println("tail: " + dequeue.getTail());
    System.out.println(dequeue);
    System.out.println("peek: " + dequeue.peek());
    System.out.println("poll: " + dequeue.poll());
    System.out.println("size: " + dequeue.getSize());
    System.out.println(dequeue);
    System.out.println("root: " + dequeue.getRoot());
    System.out.println("tail: " + dequeue.getTail());
    System.out.println(dequeue.insertAt(99, 1));
    System.out.println(dequeue);
    System.out.println("updated size: " + dequeue.getSize());
    System.out.println("root: " + dequeue.getRoot());
    System.out.println("tail: " + dequeue.getTail());
    System.out.println(dequeue.deleteAt(2));
    System.out.println(dequeue);
    dequeue.offerFirst(100);
    dequeue.offerLast(10);
    System.out.println(dequeue);
    System.out.println("peek-last: " + dequeue.peekLast());
    System.out.println("poll-last: " + dequeue.pollLast());
    System.out.println("size: " + dequeue.getSize());
    System.out.println(dequeue);
  }
}
