package com.company;

import com.company.stack.LinkedStack;

public class Main {

    public static void main(String[] args) {
        //System.out.println(fac(5));
//        LinkedList list1 = new LinkedList();
//        list1.addFirst("bob");
//        list1.addFirst("tim");
//        list1.addFirst("john");
//        list1.addFirst("rob");
//        list1.addFirst("steve");
//        LinkedList list2 = list1.recursiveReverse(list1.head.next);
//        System.out.println(list1);
//        System.out.println(list2);
//        list2.reverse2();
//        System.out.println(list2);
        //two(3);
        //four(3);
        LinkedStack ls1 = new LinkedStack();
        LinkedStack.main(null); //demo method of LinkedStack
    }

    static int fac(int n) {
        if (n == 0) {
            return 1;
        }else {
            return n * fac(n-1);
        }
    }

    public static void two (int n) {
        if (n > 0) {
            System.out.println("n: " + n);
            two (n-1);
            two (n-1);
        }else if (n < 0) {
            two (n+1);
            two (n+1);
            System.out.println("n: " + n);
        }
    }

    public static void four (int n) {
        if (n > 1) {
            System.out.println(n);
            four(n-1);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }
    }

}
