package com.company;

public class LinkedList {

    public class Node {
        public Object data;
        public Node next;

        public Node( Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(Object data) {
            this(data, null);
        }
    }//end of the Node class

    public int size;
    public Node head;

    //constructor
    public LinkedList() { //this creates an empty linklist
        this.head = new Node(null, null);
        this.size = 0;
    }

    public void addFirst (Object data) {
        Node nn = new Node(data, this.head.next);
        this.head.next = nn;
        this.size++;
    }

    public void addLast (Object data) {
        Node cur = this.head;
        Node nn = new Node(data, null);
        int i = 0;
        while(i < size) {
            cur = cur.next;
            i++;
        }
        cur.next = nn;
        this.size++;
    }

    public LinkedList recursiveReverse(Node node) {
        if (node == null) {
            return new LinkedList();
        }
        LinkedList remain = recursiveReverse(node.next);
        remain.addLast(node.data);

        return remain;
    }

    public void reverse2() {
        if(this.size <= 1) {
            return;
        }
        this.head.next = reverse(this.head.next, this.head.next.next);
    }

    public Node reverse(Node first, Node second) {
        Node h = null;
        if (second != null) {
            h = reverse(second, second.next);
            second.next = first;
            first.next = null;
        }else {
            return first;
        }
        return h;
    }

    @Override
    public String toString() {
        String result = "{";
        for (Node node = this.head.next; node != null; node = node.next) {
            if(node.next != null)
                result += node.data + "->";
            else
                result += node.data;
        }
        return result + "}";
    }
}

