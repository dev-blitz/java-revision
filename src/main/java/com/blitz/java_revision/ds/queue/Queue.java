package com.blitz.java_revision.ds.queue;

import com.blitz.java_revision.ds.pointer.*;

public class Queue {
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

  @Override
  public String toString() {
    if (size <= 0)
      throw new IncorrectQueueOperationException("nothing to print");
    NodePointer node = root;
    StringBuilder sb = new StringBuilder("START => ");
    while (node != tail) {
      sb.append(node.getData() + " => ");
      node = node.getNext();
    }
    sb.append(tail.getData() + " => END");
    return sb.toString();
  }

  public void offer(int data) {
    NodePointer node = new NodePointer(data);
    if (root == null) {
      root = node;
      tail = node;
      root.setNext(tail);
    } else {
      tail.setNext(node);
      tail = node;
    }
    size++;
  }

  public int poll() {
    if (size <= 0)
      throw new IncorrectQueueOperationException("cannot poll from Empty Queue");    

    NodePointer node = root;

    while (node.getNext() != tail)
      node = node.getNext();
    
    int deleted = node.getData();
    size--;

    return deleted;
  }

  public int peek() {
    if (size <= 0)
      throw new IncorrectQueueOperationException("nothing to peek");
    return tail.getData();
  }

  private static class IncorrectQueueOperationException extends RuntimeException {
    public IncorrectQueueOperationException(String message) {
      super(message);
    }
  }
}
