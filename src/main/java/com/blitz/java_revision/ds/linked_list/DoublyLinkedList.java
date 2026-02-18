package com.blitz.java_revision.ds.linked_list;

import com.blitz.java_revision.ds.exceptions.IncorrectDataStructureOperationException;
import com.blitz.java_revision.ds.pointer.NodePointer;

public class DoublyLinkedList extends LinkedListFactory {
  public DoublyLinkedList() {
    super();
  }

  @Override
  public String toString() {
    return buildStringForward();
  }

  @Override
  public void pushFirst(int data) {
    NodePointer node = new NodePointer(data);
    if (getRoot() == null) {
      setRoot(node);
      setTail(node);
    } else {
      node.setNext(getRoot());
      getRoot().setPrevious(node);
      setRoot(node);
    }
    incrementSize();
  }

  @Override
  public void pushLast(int data) {
    NodePointer node = new NodePointer(data);
    if (getTail() == null) {
      setRoot(node);
      setTail(node);
    } else {
      getTail().setNext(node);
      node.setPrevious(getTail());
      setTail(node);
    }
    incrementSize();
  }
  
  @Override
  public void offerFirst(int data) {
    pushFirst(data);
  }

  @Override
  public void offerLast(int data) {
    pushLast(data);
  }

  public int deleteFirst() {
    checkEmpty();

    NodePointer deleted = getRoot();
    if (getSize() == 1) {
      setRoot(null);
      setTail(null);
      decrementSize();
      return deleted.getData();
    }
    setRoot(getRoot().getNext());
    getRoot().setPrevious(null);
    decrementSize();
    return deleted.getData();
  }

  public int deleteLast() {
    checkEmpty();

    NodePointer deleted = getTail();
    if (getSize() == 1) {
      setRoot(null);
      setTail(null);
      decrementSize();
      return deleted.getData();
    }
    setTail(getTail().getPrevious());
    getTail().setNext(null);
    decrementSize();
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

    if (index == getSize()) {
      offerLast(data);
      return true;
    }

    checkIndexForInsert(index);

    NodePointer node = getRoot();
    for (int i = 1; i < index; i++)
      node = node.getNext();

    NodePointer newNode = new NodePointer(data, node.getNext(), node);
    node.setNext(newNode);
    if (newNode.getNext() != null) {
      node = node.getNext().getNext();
      node.setPrevious(newNode);
    }
    incrementSize();
    return true;
  }

  @Override
  public int deleteAt(int index) {
    if (index == 0)
      return pollFirst();

    if (index == getSize() - 1)
      return pollLast();

    checkIndexForDelete(index);
    
    NodePointer node = getRoot();
    for (int i = 1; i < index; i++)
      node = node.getNext();
    NodePointer deleted = node.getNext();
    node.setNext(node.getNext().getNext());
    node = node.getNext();
    node.setPrevious(node.getPrevious().getPrevious());
    decrementSize();
    return deleted.getData();
  }
}
