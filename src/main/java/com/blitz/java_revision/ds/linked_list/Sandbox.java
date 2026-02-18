package com.blitz.java_revision.ds.linked_list;

public class Sandbox {
  public static void main(String[] args) {
    SinglyLinkedList list = new SinglyLinkedList();
    list.addLast(0);
    list.addLast(1);
    list.addFirst(2);
    list.addFirst(3);
    System.out.println("size: " + list.getSize());
    System.out.println("root: " + list.getRoot());
    System.out.println("tail: " + list.getTail());
    System.out.println(list);
    System.out.println("peek: " + list.peek());
    System.out.println("peek-last: " + list.peekLast());
    System.out.println("delete-first: " + list.deleteFirst());
    System.out.println("size: " + list.getSize());
    System.out.println(list);
    System.out.println("delete-last: " + list.deleteLast());
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
    System.out.println(list.insertAt(100, 9));
  }
}
