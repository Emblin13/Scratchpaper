package com.company.recursion;

import com.company.linkedList.LinkedList;

import java.util.Arrays;

public class Recursion {

    LinkedList ll1;

    public Recursion (LinkedList ll1) {
        this.ll1 = ll1;
    }

    public LinkedList reverse() {
        return recursiveReverse(ll1.head.next);
    }

    public LinkedList recursiveReverse(LinkedList.Node node) {
        if (node == null) {
            return new LinkedList();
        }
        LinkedList remain = recursiveReverse(node.next);
        remain.addLast(node.data);

        return remain;
    }


    public void reverse2() {
        if(ll1.size <= 1) {
            return;
        }
        ll1.head.next = reverse(ll1.head.next, ll1.head.next.next);
    }

    public LinkedList.Node reverse(LinkedList.Node first, LinkedList.Node second) {
        LinkedList.Node h = null;
        if (second != null) {
            h = reverse(second, second.next);
            second.next = first;
            first.next = null;
        }else {
            return first;
        }
        return h;
    }

    public int countSpace(String str) { //Counts the white spaces in a string
        int spaceCount = 0;

        //end condition for when the string is empty or if the string passed in was null
        if (str == null || str.isEmpty()) {
            return 0;
        }
        if (str.charAt(0) == ' ') { //checks if 0th index has a white space, and increments spaceCount if it does.
            spaceCount++;
        }
        //Recursively breaks str into smaller substrings by removing the 0th index with each call, until str is empty.
        //Then adds together all of the white spaces counted and returns that number.
        spaceCount += this.countSpace(str.substring(1));
        return spaceCount;
    }

    public boolean myContains(String s1, String s2){
        boolean isSubstring = true;

        //If any of these conditions are true, then s1 is not a substring of s2. End condition for recursion
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty() || s1.length() > s2.length()) {
            return false;
        }

        //checks if s1 is a substring of the first chars in s2. So for example, if s1 has a length of 2, it checks the
        //first 2 chars in s2 to see if they match. If any of those chars don't match, isSubstring = false.
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                isSubstring = false;
            }
        }
        //The other end condition
        if (isSubstring) {
            return true;
        }
        //recursively removes the 0th index of s2 until s1 is found to be a substring of s2, or until s1 can no longer
        //be a substring of s2.
        isSubstring = myContains(s1, s2.substring(1));

        return isSubstring;
    }

    public int div(int m, int n) throws IllegalArgumentException {
        int divCount = 0;
        if (n == 0) {
            throw new IllegalArgumentException("Can't divide by 0!");
        }

        //end condition for when m div n = 0.
        if (m < n) {
            return 0;
        }

        //Since m >= n, that means m div n >= 1, so n is subtracted from m once and divCount is incremented.
        divCount = div((m-n), n) + 1;

        return divCount;
    }

    public boolean isSum24(int arr[])
    {
        return isSum24(arr, 24);
    }


    private boolean isSum24(int arr[], int targetSum) {
        boolean sumIs24;

        //Makes an exact duplicate array of arr[] so arr[] isn't modified by the method.
        int[] arrTemp = arr.clone();

        //End condition for when an empty array is passed in.
        if (arrTemp.length == 0) {
            return false;
        }
        //End condition for when there are no more elements in arr besides the sum. Returns true if the sum == targetSum
        if (arrTemp.length == 1) {
            return (arrTemp[0] == targetSum);
        }

        //Adds arr[0] to arr[1], then makes a new copy of the array with arr[0] removed. Effectively stores the sum in
        //the first element of the array.
        arrTemp[1] += arrTemp[0];
        arrTemp = Arrays.copyOfRange(arrTemp, 1, arrTemp.length);

        //Recursively calls sumIs24 with the array passed in being 1 element shorter than the original, and with the sum
        //stored in the first element.
        sumIs24 = isSum24(arrTemp, targetSum);

        return sumIs24;
    }

    public void reverseArray(int a[]) {
        reverseArray(a, 0, a.length - 1);
    }


    private void reverseArray(int a[], int low, int high) {

        //End condition is simply when low < high == false
        if (low < high) {
            //Swap the elements at the low and high indexes
            int temp = a[low];
            a[low] = a[high];
            a[high] = temp;

            //Recursively calls the reverseArray method with the bounds shrunk by 1 each.
            reverseArray(a, ++low, --high);//Recursive
        }
    }

    public void recursiveSelectionSort(int a[]) {
        recursiveSelectionSort(a, 0, a.length - 1); //
    }


    private void recursiveSelectionSort(int a[], int low, int high) {

        //End condition. Occurs once the sorted region contains the whole array.
        if (low == high) {
            return;
        }

        //Traverses unsorted region of array and finds the smallest element
        int minIndex = low;
        for (int j = low + 1; j < high + 1; j++) {
            if (a[j] < a[minIndex]) {
                minIndex = j;
            }
        }

        //Swap the smallest element with the first unsorted data.
        int temp = a[minIndex];
        a[minIndex] = a[low];
        a[low] = temp;

        //Recursively call recursiveSelectionSort with the sorted region incremented forwards
        recursiveSelectionSort(a, low + 1, high);
    }

    public void demo () {
        LinkedList.initializeList(ll1);

        System.out.println("---------Test Reverse()-------");
        System.out.println(ll1);
        ll1 = this.reverse();
        System.out.println(ll1);

        System.out.println("\n-------Test Reverse2()---------");
        this.reverse2();
        System.out.println(ll1);

        System.out.println("\n-------Test countSpace()----------");
        String s1 = "s p a c e      !";
        System.out.println("String: " + s1 + "\nSpaces in the string: " + this.countSpace(s1));

        System.out.println("\n-----Test myContains()------------");
        System.out.println( this.myContains("an", "banana"));
        System.out.println( this.myContains("bn", "banana"));

        System.out.println("\n-----Test div()------------");
        System.out.println( this.div(11, 3) );
        System.out.println( this.div(12, 5) );

        System.out.println("\n-----Test isSum24()------------");
        int a[] = {6, 3, 8, 3, 4, 9, 14};
        int b[] = {5, 6, 7};
        int c[] = {24};
        System.out.println( this.isSum24(a) ); //true
        System.out.println( this.isSum24(b) ); //false
        System.out.println( this.isSum24(c) ); //true

        System.out.println("\n-----Test reverseArray()------------");
        System.out.println(Arrays.toString(a)); //63834914
        this.reverseArray(a);
        System.out.println(Arrays.toString(a));//14943836

        System.out.println("\n-----Test recursiveSelectionSort()------------");
        System.out.println(Arrays.toString(a));
        this.recursiveSelectionSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

        int f[] = {2, 5, 1, 7, 9, 3, 6, 8};
        System.out.println("\n" + Arrays.toString(f));
        this.recursiveSelectionSort(f, 0, f.length - 1);
        System.out.println(Arrays.toString(f));
    }

}
