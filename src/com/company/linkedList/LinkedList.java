package com.company.linkedList;

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

    public static void initializeList (LinkedList ll1) {
        ll1.addLast("Bob Smith");
        ll1.addLast("Space");
        ll1.addLast("John");
        ll1.addLast("Henry");
        ll1.addLast("Apple");
        ll1.addLast("Yogurt");
        ll1.addLast("Pizza");
    }

    public static void demo () {
        LinkedList ll1 = new LinkedList();
        initializeList(ll1);
        System.out.println(ll1);
        ll1.addFirst("12345");
        ll1.addLast("abcde");
        System.out.println(ll1);
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

