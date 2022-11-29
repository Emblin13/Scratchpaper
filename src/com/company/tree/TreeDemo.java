package com.company.tree;

public class TreeDemo {

    public static void demo() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(9);
        tree.insert(4);
        tree.insert(2);
        tree.insert(11);
        tree.insert(4);
        tree.insert(7);
        tree.insert(7);
        tree.insert(0);

        tree.printTreePre();
        tree.printTreeIn();
        tree.printTreePost();
    }


}
