package com.biggaid.main;

import com.biggaid.util.IntSinglyLinkedList;

public class SinglyLinkedListApp {
    public static void main(String... args) {
        IntSinglyLinkedList numberList = new IntSinglyLinkedList();
        numberList.append(5);
        numberList.append(1);
        numberList.append(2);
        numberList.append(3);
        numberList.append(5);
        numberList.append(4);
        numberList.append(1);

        System.out.println("Size: " + numberList.size());

        System.out.println(String.format("Removed tail: %d", numberList.removeTail()));
        System.out.println(String.format("Size: %d", numberList.size()));

        System.out.println("Remove condition: >3");
        numberList.removeGreatCondition(3);
        System.out.println("Size: " + numberList.size());
    }
}
