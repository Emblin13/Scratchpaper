package com.company;

import com.company.linkedList.DoublyLLTester;
import com.company.recursion.Recursion;
import com.company.stack.LinkedStack;
import com.company.hashTable.Hashtable;

import java.util.Iterator;
import java.util.LinkedList;


public class Main {

    public static void main(String[] args) {
        //LinkedStack.main(null); //demo of LinkedStack

        //LinkedList.demo(); //demo of singular linked list with dummy head

        //DoublyLLTester.main(null); //demo of a circular doubly linked list

        //LinkedList ll1 = new LinkedList();
        //Recursion rec = new Recursion(ll1);
        //rec.demo(); //demo of recursion on a linked list

        //Hashtable.main(null); //demo of hashtable

        LinkedList<Object> llTest = new LinkedList<>();
        llTest.add("Bob");
        llTest.add("Smith");
        System.out.println(llTest.getFirst() + " " + llTest.getLast());
        Iterator<Object> iterator = llTest.iterator();

    }
}
