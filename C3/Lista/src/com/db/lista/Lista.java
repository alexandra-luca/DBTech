package com.db.lista;

public class Lista {

    private Node start;

    class Node {
        public Node() {

        }

        public Node(int val) {
            this.val = val;
        }

        private int val;
        private Node next;
    }


    public void add(int val) {

        if (start == null) {
            start = new Node(val);
            return;
        }

        Node curr = start;

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = new Node(val);
    }

    public void printList() {
        Node curr = start;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
}
