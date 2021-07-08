package com.db.lista;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Lista myList = new Lista();

        myList.add(5);
        myList.add(6);
        myList.add(7);
        myList.add(8);

//        myList.printList();
//
//        System.out.println(myList.size());

        myList.addAtPosition(1, 8);
        myList.printList();
    }
}
