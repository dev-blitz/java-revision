package com.blitz.java_revision.ds.linked_list;

import com.blitz.java_revision.ds.pointer.NodePointer;

public class SinglyLinkedList extends LinkedListFactory {
  public SinglyLinkedList() {
    super();
  }

  @Override
  public String toString() {
    return buildStringForward();
  }

  @Override
  public void pushLast(int data) {
    NodePointer node = new NodePointer(data);
    if (getRoot() == null) {
      setRoot(node);
      setTail(node);
    } else {
      getTail().setNext(node);
      setTail(node);
    }
    incrementSize();
  }

  @Override
  public void pushFirst(int data) {
    NodePointer node = new NodePointer(data);
    if (getRoot() == null) {
      setRoot(node);
      setTail(node);
    } else {
      node.setNext(getRoot());
      setRoot(node);
    }
    incrementSize();
  }
 
  @Override
  public void offer(int data) {
     pushLast(data);     
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
    decrementSize();
    return deleted.getData();
  }

  public int deleteLast() {
    checkEmpty();
    NodePointer node = getRoot();
    if (getSize() == 1) {
      setRoot(null);
      setTail(null);
      decrementSize();
      return node.getData();
    }
    int deleted = getTail().getData();
    while (node.getNext() != getTail())
      node = node.getNext();
    setTail(node);
    getTail().setNext(null);
    decrementSize();
    return deleted;
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
      pushFirst(data);
      return true;
    }
    
    if (index == getSize()) {
      pushLast(data);
      return true;
    }

    checkIndexForInsert(index);

    NodePointer node = getRoot();
    for (int i = 1; i < index; i++)
      node = node.getNext();

    node.setNext(new NodePointer(data, node.getNext()));
    incrementSize();
    return true;
  }

  @Override
  public int deleteAt(int index) {
    checkIndexForDelete(index);

    if (index == 0)
      return deleteFirst();

    if (index == getSize() - 1)
      return deleteLast();

    NodePointer node = getRoot();
    for (int i = 1; i < index; i++)
      node = node.getNext();
    int deleted = node.getNext().getData();
    node.setNext(node.getNext().getNext());
    decrementSize();
    return deleted;
  }
}
