package com.company.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Maciek on 2017-02-18.
 */
public class ArrayPairSum {
    private int[] initArray() {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            int randomNum = (int) (Math.random() * 10);
            array[i] = randomNum;
        }
        System.out.println("Array: " + Arrays.toString(array));
        return array;
    }

    private void sumOfPair(int sum, int[] array) {
        int sumToCheck;
        List<PairWrapper> pairs = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                sumToCheck = array[i] + array[j];
                if (sumToCheck == sum) {
                    pairs.add(new PairWrapper(array[i], array[j]));
                }
            }
        }

        if (pairs.isEmpty()) {
            System.out.println("No pairs match the requested sum.");
        } else {
            System.out.println("Pairs that match the requested sum:");
            for (PairWrapper pair : pairs) {
                System.out.println(pair.getFirst() + ", " + pair.getSecond());
            }
        }
    }

    public static void main(String[] args) {
        ArrayPairSum arrayPairSum = new ArrayPairSum();
        arrayPairSum.sumOfPair(5, arrayPairSum.initArray());
    }
}
