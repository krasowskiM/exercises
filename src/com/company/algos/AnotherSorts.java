package com.company.algos;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Maciek on 2017-02-06.
 */
public class AnotherSorts {

    private void bubbleSort(){
        int n, temp;
        boolean sorted = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Put in the size of the array");
        n = input.nextInt();
        int[] toSort = new int[n];
        System.out.println("Please put in the numbers to sort in array.");
        for (int i = 0; i < n; i++){
            toSort[i] = input.nextInt();
        }

        while (!sorted) {
            for (int i = 0; i < toSort.length - 1; i++) {
                sorted = true;
                if (toSort[i] > toSort[i + 1]) {
                    temp = toSort[i];
                    toSort[i] = toSort[i + 1];
                    toSort[i + 1] = temp;
                    sorted = false;
                }
            }
        }

        System.out.println("Sorted array: " + Arrays.toString(toSort));
    }

    public static void main(String[] args){
        AnotherSorts anotherSorts = new AnotherSorts();
        anotherSorts.bubbleSort();
    }
}
