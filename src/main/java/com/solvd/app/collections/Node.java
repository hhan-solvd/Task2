package com.solvd.app.collections;

public class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T data) {
        value = data;
        next = null;
    }

    public T getValue() {
        return value;
    }

    public void setNext(Node<T> node) {
        next = node;
    }

    public Node<T> getNext() {
        return next;
    }
}
