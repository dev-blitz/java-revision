package com.blitz.java_revision.ds.dequeue;

import com.blitz.java_revision.ds.exceptions.IncorrectDataStructureOperationException;
import com.blitz.java_revision.ds.pointer.NodePointer;

public class Dequeue {
  private int size;
  private NodePointer root;
  private NodePointer tail;

  public Dequeue() {
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
    StringBuilder sb = new StringBuilder("START => ");
    NodePointer node = root;
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
      tail.setPrevious(node);
    } else {
      tail.setNext(node);
      node.setPrevious(tail);
    }
    size++;
  }

  public void offerFirst(int data) {
    NodePointer node = new NodePointer(data);
    if (root == null) {
      root = node;
      tail = node;
      root.setNext(tail);
      tail.setPrevious(root);
    } else {
      node.setNext(root);
      root.setPrevious(node);
      root = node;
    }
    size++;
  }

  public void offerLast(int data) {
    offer(data);
  }
 
  public int poll() {
    if (size == 0)
      throw new IncorrectDataStructureOperationException("\n\t" + this.getClass().getName() + ": nothing to poll");

    int deleted = root.getData();
    root = root.getNext();
    root.setPrevious(null);
    size--;

    return deleted;
  }

  public int pollFirst() {
    return poll();
  }

  public int pollLast() {
    if (size == 0)
      throw new IncorrectDataStructureOperationException("\n\t" + this.getClass().getName() + ": nothing to poll");
    int deleted = tail.getData();
    tail = tail.getPrevious();
    tail.setNext(null);
    size--;
    return deleted;
  }

  public int peek() {
    return root.getData();
  }

  public int peekFirst() {
    return peek();
  }

  public int peekLast() {
    return tail.getData();
  }

  public boolean insertAt(int data, int index) {
    if (index == size) {
      offerLast(data);
      return true;
    }

    if (index == 0) {
      offerFirst(data);
      return true;
    }

    if (index < 0 || index > size)
      throw new IncorrectDataStructureOperationException("\n\t" + this.getClass().getName() + ": cannot insert at incorrect index");

    NodePointer node = root;
    for (int i = 1; i < index; i++)
      node = node.getNext();

    node.setNext(new NodePointer(data, node.getNext(), node.getPrevious()));
    size++;
    return true;
  }

  public int deleteAt(int index) {
    if (index == 0)
      return pollFirst();
    
    if (index == size - 1)
      return pollLast();
    
    if (index < 0 || index > size)
      throw new IncorrectDataStructureOperationException("\n\t" + this.getClass().getName() + ": cannot delete at incorrect index");
    
    NodePointer node = root;
    for (int i = 1; i < index; i++)
      node = node.getNext();

    int deleted = node.getNext().getData();
    node.setNext(node.getNext().getNext());
    size--;
    return deleted;
  }
}
