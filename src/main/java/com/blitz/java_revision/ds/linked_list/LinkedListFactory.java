package com.blitz.java_revision.ds.linked_list;

import com.blitz.java_revision.ds.exceptions.IncorrectDataStructureOperationException;
import com.blitz.java_revision.ds.pointer.NodePointer;

public abstract class LinkedListFactory implements LinkedList {
  private int size;
  private NodePointer root;
  private NodePointer tail;
  
  protected LinkedListFactory() {
    size = 0;
    root = null;
    tail = null;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  protected int getSize() {
    return size;
  }

  protected NodePointer getRoot() {
    return root;
  }

  protected void setRoot(NodePointer node) {
    root = node;
  }

  protected NodePointer getTail() {
    return tail;
  }

  protected void setTail(NodePointer node) {
    tail = node;
  }

  protected void incrementSize() {
    size++;
  }

  protected void decrementSize() {
    size--;
  }

  @Override
  public int peekFirst() {
    if (root == null)
      throw new IncorrectDataStructureOperationException("\n\t" + this.getClass().getName() + "=> empty list");
    return root.getData();
  }

  @Override
  public int peekLast() {
    if (root == null)
      throw new IncorrectDataStructureOperationException("\n\t" + this.getClass().getName() + "=> empty list");
    return tail.getData();
  }

  @Override
  public String debug() {
    return "root: " + tail + ", tail: " + tail;
  }
}
