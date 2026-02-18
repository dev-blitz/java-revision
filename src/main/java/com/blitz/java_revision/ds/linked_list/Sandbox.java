package com.blitz.java_revision.ds.linked_list;

public class Sandbox {
  public static void main(String[] args) {
    LinkedList list = new SinglyLinkedList();
    list.offerLast(0);
    list.offerLast(1);
    list.offerFirst(2);
    list.offerFirst(3);
    System.out.println("size: " + list.getSize());
    System.out.println("root: " + list.getRoot());
    System.out.println("tail: " + list.getTail());
    System.out.println(list);
    System.out.println("peek: " + list.peek());
    System.out.println("peek-last: " + list.peekLast());
    System.out.println("delete-first: " + list.pollFirst());
    System.out.println("size: " + list.getSize());
    System.out.println(list);
    System.out.println("delete-last: " + list.pollLast());
    System.out.println(list);
    System.out.println("root: " + list.getRoot());
    System.out.println("tail: " + list.getTail());
    System.out.println(list.insertAt(99, 1));
    System.out.println(list);
    System.out.println("updated size: " + list.getSize());
    System.out.println("root: " + list.getRoot());
    System.out.println("tail: " + list.getTail());
    System.out.println(list.deleteAt(2));
    System.out.println(list);
    // System.out.println(list.insertAt(100, 9));
    list = new DoublyLinkedList();
    list.offerLast(0);
    list.offerLast(1);
    list.offerFirst(2);
    list.offerFirst(3);
    System.out.println("size: " + list.getSize());
    System.out.println("root: " + list.getRoot());
    System.out.println("tail: " + list.getTail());
    System.out.println(list);
    System.out.println("peek: " + list.peek());
    System.out.println("peek-last: " + list.peekLast());
    System.out.println("delete-first: " + list.pollFirst());
    System.out.println("size: " + list.getSize());
    System.out.println(list);
    System.out.println("delete-last: " + list.pollLast());
    System.out.println(list);
    System.out.println("root: " + list.getRoot());
    System.out.println("tail: " + list.getTail());
    System.out.println(list.insertAt(99, 1));
    System.out.println(list);
    System.out.println("updated size: " + list.getSize());
    System.out.println("root: " + list.getRoot());
    System.out.println("tail: " + list.getTail());
    System.out.println(list.deleteAt(2));
    System.out.println(list);
  }
}
