package com.blitz.java_revision.ds.linked_list;

import com.blitz.java_revision.ds.exceptions.IncorrectDataStructureOperationException;
import com.blitz.java_revision.ds.pointer.NodePointer;

public class SinglyLinkedList extends LinkedList {
  public SinglyLinkedList() {
    super.setSize(0);
    super.setRoot(null);
    super.setTail(null);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("START => ");
    if (super.getSize() > 0) {
      NodePointer node = super.getRoot();
      while (node != super.getTail()) {
        sb.append(node.getData() + " => ");
        node = node.getNext();
      }
      sb.append(super.getTail().getData());
    }
    sb.append("END");
    return sb.toString();
  }

  public void addLast(int data) {
    NodePointer node = new NodePointer(data);
    if (super.getRoot() == null) {
      super.setRoot(node);
      super.setTail(node);
    } else {
      super.getTail().setNext(node);
      super.setTail(node);
    }
    super.setSize(super.getSize() + 1);
  }

  public void addFirst(int data) {
    NodePointer node = new NodePointer(data);
    if (super.getRoot() == null) {
      super.setRoot(node);
      super.setTail(node);
    } else {
      node.setNext(super.getRoot());
      super.setRoot(node);
    }
    super.setSize(super.getSize() + 1);
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
    if (super.getSize() <= 0 || super.getRoot() == null)
      throw new IncorrectDataStructureOperationException("\n\t" + this.getClass().getName() + ": cannot delete at incorrect index");
    NodePointer deleted = super.getRoot();
    if (super.getSize() == 1) {
      super.setRoot(null);
      super.setTail(null);
      super.setSize(super.getSize() - 1);
      return deleted.getData();
    }
    super.setRoot(super.getRoot().getNext());
    super.setSize(super.getSize() - 1);
    return deleted.getData();
  }

  public int deleteLast() {
    if (super.getSize() <= 0 || super.getTail() == null)
      throw new IncorrectDataStructureOperationException("\n\t" + this.getClass().getName() + ": cannot delete at incorrect index");
    NodePointer node = super.getRoot();
    if (super.getSize() == 1) {
      super.setRoot(null);
      super.setTail(null);
      super.setSize(super.getSize() - 1);
      return node.getData();
    }
    int deleted = super.getTail().getData();
    while (node.getNext() != super.getTail())
      node = node.getNext();
    super.setTail(node);
    super.getTail().setNext(null);
    super.setSize(super.getSize() - 1);
    return deleted;
  }

  @Override
  public int poll() {
     return deleteFirst();
  }

  @Override
  public int pollFirst() {
    return poll();
  }

  @Override
  public int pollLast() {
    return deleteLast();
  }

  @Override
  public boolean insertAt(int data, int index) {
    if (index == 0) {
      addFirst(data);
      return true;
    }
    
    if (index == super.getSize()) {
      addLast(data);
      return true;
    }

    if (index < 0 || index > super.getSize())
      throw new IncorrectDataStructureOperationException("\n\t" + this.getClass().getName() + ": cannot insert at incorrect index");

    NodePointer node = super.getRoot();
    for (int i = 1; i < index; i++)
      node = node.getNext();

    node.setNext(new NodePointer(data, node.getNext()));
    super.setSize(super.getSize() + 1);
    return true;
  }

  @Override
  public int deleteAt(int index) {
    if (index < 0 || index >= super.getSize())
      throw new IncorrectDataStructureOperationException("\n\t" + this.getClass().getName() + ": cannot insert at incorrect index");

    if (index == 0)
      return deleteFirst();

    if (index == super.getSize() - 1)
      return deleteLast();

    NodePointer node = super.getRoot();
    for (int i = 1; i < index; i++)
      node = node.getNext();
    int deleted = node.getNext().getData();
    node.setNext(node.getNext().getNext());
    super.setSize(super.getSize() - 1);
    return deleted;
  }
}
