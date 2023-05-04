package com.solvd.app.collections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LinkedList<T> {
    private static final Logger LOGGER = LogManager.getLogger(LinkedList.class);
    private Node<T> head;
    private Node<T> previousNode;
    private int size;

    public int getSize() {
        return size;
    }

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void addNode(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    public void removeNode(T data) {
        if (head.getValue().equals(data)) {
            head = head.getNext();
            size--;
            return;
        }

        // Remove the node
        previousNode.setNext(previousNode.getNext().getNext());
        size--;
    }

    public boolean findNode(T data) {
        if (head == null) {
            return false;
        }

        // Check if the node is the head
        if (head.getValue().equals(data)) {
            return true;
        }

        Node<T> previous = head;
        while (previous.getNext() != null && !previous.getNext().getValue().equals(data)) {
            previous = previous.getNext();
        }

        // Return false if the target node was not found
        if (previous.getNext() == null) {
            return false;
        }

        previousNode = previous;
        return true;
    }

    public void show() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            LOGGER.info(currentNode.getValue() + " ");
            currentNode = currentNode.getNext();
        }
    }
}