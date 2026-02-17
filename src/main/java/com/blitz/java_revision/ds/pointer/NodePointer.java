package com.blitz.java_revision.ds.pointer;

public class NodePointer {
  private int data;
  private NodePointer next;
  private NodePointer previous;

  public NodePointer(int data) {
    this.data = data;
  }

  public NodePointer(int data, NodePointer next) {
    this.data = data;
    this.next = next;
  }

  public NodePointer(int data, NodePointer next, NodePointer previous) {
    this.data = data;
    this.next = next;
    this.previous = previous;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public NodePointer getNext() {
    return next;
  }

  public void setNext(NodePointer next) {
    this.next = next;
  }

  public NodePointer getPrevious() {
    return previous;
  }

  public void setNodePointer(NodePointer previous) {
    this.previous = previous;
  }

  @Override
  public String toString() {
    return "data: " + data;
  }
}
