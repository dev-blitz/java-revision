package com.blitz.java_revision.ds.linked_list;

import com.blitz.java_revision.ds.pointer.NodePointer;
import com.blitz.java_revision.ds.exceptions.IncorrectDataStructureOperationException;

public abstract class LinkedList {
  private int size;
  private NodePointer root;
  private NodePointer tail;
  
  public int getSize() {
    return size;
  }

  public NodePointer getRoot() {
    return root;
  }

  public NodePointer getTail() {
    return tail;
  }

  public int peek() {
    if (size <= 0 || tail == null)
      throw new IncorrectDataStructureOperationException("\n\t" + this.getClass().getName() + ": nothing to peek");
    return tail.getData();
  }

  public int peekFirst() {
    if (size <= 0 || root == null)
      throw new IncorrectDataStructureOperationException("\n\t" + this.getClass().getName() + ": nothing to peek");
    return root.getData();
  }

  public int peekLast() {
    return peek();
  }

  public abstract void offer(int data);
  public abstract void offerFirst(int data);
  public abstract void offerLast(int data);
  public abstract int poll();
  public abstract int pollFirst();
  public abstract int pollLast();
  public abstract boolean insertAt(int data, int index);
  public abstract int deleteAt(int index);
}
