package com.blitz.java_revision.ds.queue;

import com.blitz.java_revision.ds.pointer.*;

public class Queue {
  private int size;
  private NodePointer root;
  private NodePointer tail;
  
  public Queue() {
    size = 0;
  }

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

    int deleted = root.getData();
    root = root.getNext();
    size--;

    return deleted;
  }

  public int peek() {
    if (size <= 0)
      throw new IncorrectQueueOperationException("nothing to peek");
    return tail.getData();
  }
  
  public boolean insertAt(int data, int index) {
    if (index == size) {
      offer(data);
      return true;
    }

    if (index < 0 || index > size)
      throw new IncorrectQueueOperationException("cannot insert at incorrect index");

    NodePointer node = root;
    for (int i = 1; i < index; i++)
      node = node.getNext();
    node.setNext(new NodePointer(data, node.getNext()));
    size++;
    return true;
  }

  public int deleteAt(int index) {
    if (index == 0)
      return poll();

    if (index > size)
      throw new IncorrectQueueOperationException("cannot delete from incorrect index");

    NodePointer node = root;
    for (int i = 1; i < index; i++)
      node = node.getNext();

    int deleted = node.getNext().getData();
    node.setNext(node.getNext().getNext());
    size--;
    return deleted;
  }

  private static class IncorrectQueueOperationException extends RuntimeException {
    public IncorrectQueueOperationException(String message) {
      super(message);
    }
  }
}
