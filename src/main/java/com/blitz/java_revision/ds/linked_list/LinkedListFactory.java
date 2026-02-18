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
    ensureNotEmpty();
    return root.getData();
  }

  @Override
  public int peekLast() {
    ensureNotEmpty();
    return tail.getData();
  }

  @Override
  public String debug() {
    return "root: " + root + ", tail: " + tail;
  }

  protected String buildStringForward() {
    StringBuilder sb = new StringBuilder("START => ");
    if (getSize() > 0) {
      NodePointer node = getRoot();
      while (node != getTail()) {
        sb.append(node.getData() + " => ");
        node = node.getNext();
      }
      sb.append(getTail().getData() + " => ");
    }
    sb.append("END");
    return sb.toString();
  }

  protected void ensureNotEmpty() {
    if (root == null)
      throw new IncorrectDataStructureOperationException("\n\t" + this.getClass().getSimpleName() + "=> list is empty");
  }

  protected void checkIndexForInsert(int index) {
    if (index < 0 || index > getSize())
      throw new IncorrectDataStructureOperationException("\n\t" + this.getClass().getName() + ": IndexOutOfBound for Insert: index=" + getSize() + index + ", size=" + getSize());
  }

  protected void checkIndexForDelete(int index) {
    if (index < 0 || index >= getSize())
      throw new IncorrectDataStructureOperationException("\n\t" + this.getClass().getName() + ": IndexOutOfBound for Delete: index=" + getSize() + index + ", size=" + getSize());
  }

  protected void checkEmpty() {
    if (getSize() == 0)
      throw new IncorrectDataStructureOperationException("\n\t" + this.getClass().getSimpleName() + ": empty list");
  }
}
