package com.company.tree;

public class BinarySearchTree {
    // Root node pointer. Will be null for an empty tree.
    private Node root;

    private class Node {
        Node left;
        Node right;
        int data; //To be general, the type should be Comparable

        public Node(int newData) {
            left = null;
            right = null;
            data = newData;
        }
    }

    /**
     * Creates an empty binary tree -- a null root pointer.
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * Inserts the given data into the binary tree.
     * Uses a recursive helper.
     */
    public void insert(int data) {
        root = insert(root, data);
    }

    /**
     * Recursive insert -- given a node pointer, recur down and
     * insert the given data into the tree. Returns the new
     * node pointer (the standard way to communicate
     * a changed pointer back to the caller).
     */
    private Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else {
            if (data < node.data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }
        return (node); // in any case, return the new pointer to the caller
    }

    public boolean lookup(int data) {
        return (lookup(root, data));
    }

    /**
     * Recursive lookup  -- given a node, recur
     * down searching for the given data.
     */
    private boolean lookup(Node node, int data) {
        if (node == null) {
            return (false);
        }
        if (data == node.data) {
            return (true);
        } else if (data < node.data) {
            return (lookup(node.left, data));
        } else {
            return (lookup(node.right, data));
        }
    }

    public void printTreeIn() {  //inorder traversal
        System.out.println("Inorder traversal");
        printTreeIn(root);
        System.out.println();
    }

    private void printTreeIn(Node node) {
        if (node == null) return;
// left, node itself, right
        printTreeIn(node.left);
        System.out.print(node.data + "  ");
        printTreeIn(node.right);
    }

    public void printTreePre() {  //preorder traversal
        System.out.println("Preorder traversal");
        printTreePre(root);
        System.out.println();
    }

    private void printTreePre(Node node) {
        if (node == null) return;

        System.out.print(node.data + "  ");
// node itself, left, right
        printTreePre(node.left);
        printTreePre(node.right);
    }

    public void printTreePost() {  //postorder traversal
        System.out.println("Postorder traversal");
        printTreePost(root);
        System.out.println();
    }
    private void printTreePost(Node node) {
        if (node == null) return;

        // left, right,  then node itself
        printTreePost(node.left);
        printTreePost(node.right);
        System.out.print(node.data + "  ");
    }

    private Node copyTree(Node rt) {
        if (rt == null)
            return null;
        //copy the root node
        Node newRoot = new Node(rt.data);
        newRoot.left = copyTree(rt.left);
        newRoot.right = copyTree(rt.right);
        return newRoot;
    }

    public BinarySearchTree copyTree() {
        BinarySearchTree newTree = new BinarySearchTree();
        newTree.root = copyTree(this.root);
        return newTree;
    }

}