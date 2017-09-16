package com.biggaid.util;

import java.util.NoSuchElementException;

public class IntSinglyLinkedList {
    IntNode<Integer> head;
    int size;

    public IntSinglyLinkedList() {
        size = 0;
    }

    /**
     * Append e as last element
     */
    public void append(Integer e) {
        final IntNode<Integer> h = head;
        final IntNode<Integer> newNode = new IntNode<Integer>(e, null);
        if (h == null) {
            head = newNode;
        } else {
            IntNode<Integer> prevTail = h;
            while (prevTail.next != null) {
                prevTail = prevTail.next;
            }
            prevTail.next = newNode;
        }
        size ++;
    }

    /**
     * Removes and returns the tail element from this list
     *
     * @return the tail element from this list
     * @throws NoSuchElementException if this list is empty
     */
    public Integer removeTail() {
        final IntNode<Integer> h = head;
        if (h == null)
            throw new NoSuchElementException();

        return unlinkTail(h);
    }


    /**
     * Removes and returns the head element from this list
     *
     * @return the head element from this list
     * @throws NoSuchElementException if this list is empty
     */
    public Integer removeHead() {
        final IntNode<Integer> h = head;
        if (h == null)
            throw new NoSuchElementException();
        return unlinkHead(h);
    }

    public void removeGreatCondition(Integer target) {
        final IntNode<Integer> h = head;
        if (h == null)
            throw new NoSuchElementException();

        while (head.data.compareTo(target) == 1) {
            System.out.println(String.format("Removed: %d", removeHead()));
        }

        IntNode<Integer> temp = null;
        for (IntNode<Integer> x = head; x != null; x = x.next) {
            if (x.data.compareTo(target) == 1) {
                System.out.println(String.format("Removed: %d", unlink(x)));
                x = temp;
            }
            temp = x;
        }
    }

    public int size() {
        return size;
    }

    private Integer unlink(IntNode<Integer> x) {
        final IntNode<Integer> h = head;
        final Integer element = x.data;
        final IntNode<Integer> next = x.next;

        if (next == null) {
            unlinkTail(h);
        } else {
            IntNode<Integer> prev = h;
            while (prev.next.data.compareTo(x.data) != 0) {
                prev = prev.next;
            }

            prev.next = next;
            x.data = null;
            x.next = null; // help GC

            size--;
        }

        return element;
    }

    private Integer unlinkHead(IntNode<Integer> h) {
        final Integer element = h.data;
        head = head.next;
        size --;
        return element;
    }

    private Integer unlinkTail(IntNode<Integer> h) {
        if (h.next == null) {
            removeHead();
        }

        IntNode<Integer> prevTail = h;
        while (prevTail.next.next != null)
            prevTail = prevTail.next;

        final Integer element = prevTail.next.data;
        prevTail.next.data = null; // help GC
        prevTail.next = null;
        size --;

        return element;
    }
}
