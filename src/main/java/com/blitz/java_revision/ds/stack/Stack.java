package com.blitz.java_revision.ds.stack;

import com.blitz.java_revision.ds.exceptions.IncorrectDataStructureOperationException;

public class Stack {
  private int size;
  private Node root, tail;

  public Stack() {
    size = 0;
  }

  public int getSize() {
    return size;
  }

  public int getRoot() {
    return root.data;
  }

  public int getTail() {
    return tail.data;
  }

  public void push(int data) {
    Node node = new Node(data);
    if (root == null) {
      root = node;
      tail = node;
      tail.next = root;
    } else {
      node.next = tail;
      tail = node;
    }
    size++;
  }

  public int pop() {
    if (tail == null)
      throw new IncorrectDataStructureOperationException(this.getClass().getName() + "cannot pop, Stack is empty");
    
    int deleted = tail.data;
    Node node = tail.next;
    tail = null;
    tail = node;
    size--;

    return deleted;
  }

  public int peek() {
    return tail.data;
  }

  @Override
  public String toString() {
    if (size == 0) 
      throw new IncorrectDataStructureOperationException(this.getClass().getName() + "cannot print... Stack is Empty");
    Node node = tail;
    StringBuilder sb = new StringBuilder();
    sb.append("START => ");
    while (node != root) {
      sb.append(node.data + " => ");
      node = node.next;
    }
    sb.append(root.data + " => END");
    return sb.toString();
  }

  public void print() {
    if (size == 0) 
      throw new IncorrectDataStructureOperationException(this.getClass().getName() + "cannot print... Stack is Empty");
    Node node = tail;
    System.out.print("START => ");
    while (node != root) {
      System.out.print(node.data + " => ");
      node = node.next;
    }
    System.out.println(root.data + " => END");
  }

  public boolean insert(int data, int index) {
    if (index < 0)
      throw new IncorrectDataStructureOperationException(this.getClass().getName() + "cannot insert at the incorrect index");
    if (index == size) {
      push(data);
      return true;
    }

    Node node = tail;
    for (int i = 1; i < index; i++)
      node = node.next;
    node.next = new Node(data, node.next);
    size++;
    return true;
  }

  public boolean deleteAt(int index) {
    if (index < 0 || index >= size)
      throw new IncorrectDataStructureOperationException(this.getClass().getName() + "cannot insert at the incorrect index");

    Node node = tail;
    for (int i = 1; i < index; i++)
      node = node.next;
    node.next = node.next.next;
    size--;
    return true;
  }

  private static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
    }

    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }
}
