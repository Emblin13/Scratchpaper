package com.company.mergeSort;

import java.sql.SQLOutput;
import java.util.Arrays;

public class MergeSortArray {

    public void mergeSort( Comparable array[] ) {
        mergeSort( array, 0, array.length - 1 );
    }

    private void mergeSort( Comparable [] array, int low, int high )
    {
        if(low < high) {
            int mid = (low + high) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    private void merge( Comparable [] array, int low, int mid, int high)
    {
        int leftIndex = low, rightIndex = mid + 1;
        int tempIndex = low;
        Object temp[] = new Object[array.length];

        while( leftIndex  <= mid && rightIndex <= high )
        {
            if( array[leftIndex].compareTo(array[rightIndex]) <= 0 )
            {
                temp[tempIndex] = array[leftIndex];
                leftIndex ++;
            }
            else
            {
                temp[tempIndex] = array[rightIndex];
                rightIndex ++;
            }
            tempIndex ++;
        }//end of while
        while( leftIndex  <= mid )
        {
            temp[tempIndex] = array[leftIndex];
            leftIndex ++;
            tempIndex ++;
        }

        while(rightIndex <=high)
        {
            temp[tempIndex] = array[rightIndex];
            rightIndex ++;
            tempIndex ++;
        }

        for( tempIndex = low; tempIndex <= high; tempIndex ++)
            array[tempIndex] = (Comparable)temp[tempIndex];
    }//end of merge method

    public static void main(String args[]) {
        String names[] = {"Smith", "John", "Brown", "White", "Green", "Peter"};
        System.out.println("Before sorted, the array is:" + Arrays.toString(names));
        MergeSortArray ms = new MergeSortArray();
        ms.mergeSort(names);
        System.out.println("After sorted, the array is:" + Arrays.toString(names));
    }
}
