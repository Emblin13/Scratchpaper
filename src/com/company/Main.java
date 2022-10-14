package com.company;

public class Main {

    public static void main(String[] args) {
        //System.out.println(fac(5));
        LinkedList list1 = new LinkedList();
        list1.addFirst("bob");
        list1.addFirst("tim");
        list1.addFirst("john");
        list1.addFirst("rob");
        list1.addFirst("steve");
        LinkedList list2 = list1.recursiveReverse(list1.head.next);
        System.out.println(list1);
        System.out.println(list2);
        list2.reverse2();
        System.out.println(list2);
    }

    static int fac(int n) {
        if (n == 0) {
            return 1;
        }else {
            return n * fac(n-1);
        }
    }
}
