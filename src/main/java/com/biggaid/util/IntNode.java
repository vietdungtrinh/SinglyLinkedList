package com.biggaid.util;

public class IntNode<Integer> {
    Integer data;
    IntNode<Integer> next;

    public IntNode(Integer data) {
        this.data = data;
    }

    public IntNode(Integer data, IntNode<Integer> next) {
        this.data = data;
        this.next = next;
    }

    public IntNode<Integer> getNext() {
        return next;
    }
}
