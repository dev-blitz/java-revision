package com.blitz.java_revision.ds.linked_list;

import com.blitz.java_revision.ds.exceptions.IncorrectDataStructureOperationException;
import com.blitz.java_revision.ds.pointer.NodePointer;

public class DoublyLinkedList extends LinkedList {
  public DoublyLinkedList() {
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

  public void addFirst(int data) {
    NodePointer node = new NodePointer(data);
    if (super.getRoot() == null) {
      super.setRoot(node);
      super.setTail(node);
    } else {
      node.setNext(super.getRoot());
      super.getRoot().setPrevious(node);
      super.setRoot(node);
    }
    super.setSize(super.getSize() + 1);
  }

  public void addLast(int data) {
    NodePointer node = new NodePointer(data);
    if (super.getTail() == null) {
      super.setRoot(node);
      super.setTail(node);
    } else {
      super.getTail().setNext(node);
      node.setPrevious(super.getTail());
      super.setTail(node);
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
      throw new IncorrectDataStructureOperationException("\n\t" + this.getClass().getName() + "=> nothing to delete");

    NodePointer deleted = super.getRoot();
    if (super.getSize() == 1) {
      super.setRoot(null);
      super.setTail(null);
      super.setSize(super.getSize() - 1);
      return deleted.getData();
    }
    super.setRoot(super.getRoot().getNext());
    super.getRoot().setPrevious(null);
    super.setSize(super.getSize() - 1);
    return deleted.getData();
  }

  public int deleteLast() {
    if (super.getSize() <= 0 || super.getTail() == null)
      throw new IncorrectDataStructureOperationException("\n\t" + this.getClass().getName() + "=> nothing to delete");

    NodePointer deleted = super.getTail();
    if (super.getSize() == 1) {
      super.setRoot(null);
      super.setTail(null);
      super.setSize(super.getSize() - 1);
      return deleted.getData();
    }
    super.setTail(super.getTail().getPrevious());
    super.getTail().setNext(null);
    super.setSize(super.getSize() - 1);
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

    if (index == super.getSize()) {
      offerLast(data);
      return true;
    }

    if (index < 0 || index > super.getSize()) 
      throw new IncorrectDataStructureOperationException("\n\t" + this.getClass().getName() + "=> incorrect index provided");

    NodePointer node = super.getRoot();
    for (int i = 1; i < index; i++)
      node = node.getNext();

    NodePointer newNode = new NodePointer(data, node.getNext(), node);
    node.setNext(newNode);
    if (newNode.getNext() != null) {
      node = node.getNext().getNext();
      node.setPrevious(newNode);
    }
    super.setSize(super.getSize() + 1);
    return true;
  }

  @Override
  public int deleteAt(int index) {
    if (index == 0)
      return pollFirst();

    if (index == super.getSize() - 1)
      return pollLast();

    if (index < 0 || index >= super.getSize()) 
      throw new IncorrectDataStructureOperationException("\n\t" + this.getClass().getName() + "=> incorrect index provided");
    
    NodePointer node = super.getRoot();
    for (int i = 1; i < index; i++)
      node = node.getNext();
    NodePointer deleted = node.getNext();
    node.setNext(node.getNext().getNext());
    node = node.getNext();
    node.setPrevious(node.getPrevious().getPrevious());
    super.setSize(super.getSize() - 1);
    return deleted.getData();
  }
}
