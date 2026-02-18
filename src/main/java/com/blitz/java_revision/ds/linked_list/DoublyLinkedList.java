package com.blitz.java_revision.ds.linked_list;

import com.blitz.java_revision.ds.exceptions.IncorrectDataStructureOperationException;
import com.blitz.java_revision.ds.pointer.NodePointer;

public class DoublyLinkedList extends LinkedList {
  private int size;
  private NodePointer root;
  private NodePointer tail;

  public DoublyLinkedList() {
    size = 0;
    root = null;
    tail = null;
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

  public void addFirst(int data) {
    NodePointer node = new NodePointer(data);
    if (root == null) {
      root = node;
      tail = node;
    } else {
      node.setNext(root);
      root.setPrevious(node);
      root = node;
    }
    size++;
  }

  public void addLast(int data) {
    NodePointer node = new NodePointer(data);
    if (tail == null) {
      root = node;
      tail = node;
    } else {
      tail.setNext(node);
      node.setPrevious(tail);
      tail = node;
    }
    size++;
  }
  
  @Override
  public void offer(int data) {
    addLast(data);
  }

  @Override
  public void offerFirst(int data) {
    addFirst(data);
  }

  @Override
  public void offerLast(int data) {
    addLast(data);
  }

  public int deleteFirst() {
    if (size <= 0 || root == null)
      throw new IncorrectDataStructureOperationException("\n\t" + this.getClass().getName() + "=> nothing to delete");
    NodePointer deleted = root;
    root = root.getNext();
    root.setPrevious(null);
    size--;
    return deleted.getData();
  }

  public int deleteLast() {
    if (size <= 0 || tail == null)
      throw new IncorrectDataStructureOperationException("\n\t" + this.getClass().getName() + "=> nothing to delete");
    NodePointer deleted = tail;
    tail = tail.getPrevious();
    tail.setNext(null);
    size--;
    return deleted.getData();
  }

  @Override
  public int poll() {
    return deleteFirst();
  }

  @Override
  public int pollFirst() {
    return deleteFirst();
  }

  @Override
  public int pollLast() {
    return deleteLast();
  }

  @Override
  public boolean insertAt(int data, int index) {
    if (index == 0) {
      offerFirst(data);
      return true;
    }

    if (index == size) {
      offerLast(data);
      return true;
    }

    if (index < 0 || index > size) 
      throw new IncorrectDataStructureOperationException("\n\t" + this.getClass().getName() + "=> incorrect index provided");

    NodePointer node = root;
    for (int i = 1; i < index; i++)
      node = node.getNext();

    node.setNext(new NodePointer(data, node.getNext(), node));
    size++;
    return true;
  }

  @Override
  public int deleteAt(int index) {
    if (index == 0)
      return pollFirst();

    if (index == size - 1)
      return pollLast();

    if (index < 0 || index >= size) 
      throw new IncorrectDataStructureOperationException("\n\t" + this.getClass().getName() + "=> incorrect index provided");
    
    NodePointer node = root;
    for (int i = 1; i < index; i++)
      node = node.getNext();
    NodePointer deleted = node.getNext();
    node.setNext(node.getNext().getNext());
    node = node.getNext();
    node.setPrevious(node.getPrevious().getPrevious());
    size--;
    return deleted.getData();
  }
}
