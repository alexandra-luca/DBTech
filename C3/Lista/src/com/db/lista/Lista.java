package com.db.lista;

import org.w3c.dom.Node;

public class Lista {

    private Node start;
    private int dim;


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
            dim++;
            return;
        }

        Node curr = start;

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = new Node(val);
        dim++;
    }

    public void printList() {
        Node curr = start;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

    public int size(){
        return dim;
    }


    public void addAtPosition(int val, int position){
        if(position <= dim && position >= 0){
            if(position == 0){
                Node add = new Node(val);
                add.next = start;
                start = add;
                dim++;
                return;
            }

            if(position == dim){
                Node curr = start;
                while(curr.next != null){
                    curr = curr.next;
                }
                Node add = new Node(val);
                curr.next = add;
                dim++;
                return;
            }

            Node curr = start;
            int count = 0;
            while (count < position - 1){
                curr = curr.next;
                count++;
            }
            Node add = new Node(val);
            add.next= curr.next;
            curr.next = add;
            dim++;
        }else{
            System.out.println("Pozitie invalida!");
        }
    }
}
