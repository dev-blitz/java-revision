package com.blitz.java_revision.ds.linked_list;

public interface LinkedList {
  int size();
  boolean isEmpty();

  void offerFirst(int data);
  void offerLast(int data);
  default void offer(int data) {
    offerLast(data);
  }

  int pollFirst();
  int pollLast();
  default int poll() {
    return pollFirst();
  }

  int peekFirst();
  int peekLast();
  default int peek() {
    return peekFirst();
  }

  boolean insertAt(int data, int index);
  int deleteAt(int index);

  String debug();
}
