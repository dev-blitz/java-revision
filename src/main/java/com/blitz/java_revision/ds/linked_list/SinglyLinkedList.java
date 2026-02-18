package com.blitz.java_revision.ds.linked_list;

import com.blitz.java_revision.ds.exceptions.IncorrectDataStructureOperationException;
import com.blitz.java_revision.ds.pointer.NodePointer;

public class SinglyLinkedList {
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
    StringBuilder sb = new StringBuilder("START => ");
    NodePointer node = root;
    while (node != tail) {
      sb.append(node.getData() + " => ");
      node = node.getNext();
    }
    sb.append(tail.getData() + " => END");
    return sb.toString();
  }

  public void addLast(int data) {
    NodePointer node = new NodePointer(data);
    if (root == null) {
      root = node;
      tail = node;
    } else {
      tail.setNext(node);
      tail = node;
    }
    size++;
  }

  public void addFirst(int data) {
    NodePointer node = new NodePointer(data);
    if (root == null) {
      root = node;
      tail = node;
    } else {
      node.setNext(root);
      root = node;
    }
    size++;
  }

  public int deleteFirst() {
    if (size <= 0 || root == null)
      throw new IncorrectDataStructureOperationException("\n\t" + this.getClass().getName() + ": cannot delete at incorrect index");
    int deleted = root.getData();
    root = root.getNext();
    size--;
    return deleted;
  }

  public int deleteLast() {
    if (size <= 0 || tail == null)
      throw new IncorrectDataStructureOperationException("\n\t" + this.getClass().getName() + ": cannot delete at incorrect index");
    NodePointer node = root;
    int deleted = tail.getData();
    while (node.getNext() != tail)
      node = node.getNext();
    tail = node;
    tail.setNext(null);
    size--;
    return deleted;
  }

  public boolean insertAt(int data, int index) {
    if (index == 0) {
      addFirst(data);
      return true;
    }
    
    if (index == size) {
      addLast(data);
      return true;
    }

    if (index > size)
      throw new IncorrectDataStructureOperationException("\n\t" + this.getClass().getName() + ": cannot insert at incorrect index");

    NodePointer node = root;
    for (int i = 1; i < index; i++)
      node = node.getNext();

    node.setNext(new NodePointer(data, node.getNext()));
    size++;
    return true;
  }

  public int deleteAt(int index) {
    if (index == 0)
      return deleteFirst();

    if (index == size - 1)
      return deleteLast();

    NodePointer node = root;
    for (int i = 1; i < index; i++)
      node = node.getNext();
    int deleted = node.getNext().getData();
    node.setNext(node.getNext().getNext());
    size--;
    return deleted;
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
}
