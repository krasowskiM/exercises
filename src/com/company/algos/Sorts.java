package com.company.algos;

import java.util.Arrays;

/**
 * Created by Maciek on 2017-01-25.
 */
public class Sorts {
    private int[] toSortSearch = {1, 2, 3, 4, 5, 8, 10, 11, 13, 17, 27};

    private int[] reverseArray(int[] toSort) {
        int n = toSort.length - 1;
        int temp;
        for (int i = 0; i <= n / 2; i++) {
            temp = toSort[n - i];
            toSort[n - i] = toSort[i];
            toSort[i] = temp;
//            n--;
        }

        return toSort;
    }

    private void binarySearch(int searched, int[] toSearch) {
        int l = 0, r = toSearch.length - 1, mid;
        boolean found = false;
        while (!found) {
            mid = (l + r) / 2;
            if (toSearch[mid] == searched) {
                System.out.println("Found searched number on index " + mid);
                found = true;
            } else if (toSearch[mid] < searched) {
                r = mid;
            } else if (toSearch[mid] >= searched) {
                l = mid;
            }
        }
    }

    private void bubbleSort(int[] toSort) {
        int temp;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < toSort.length - 1; i++) {
                if (toSort[i] > toSort[i + 1]) {
                    temp = toSort[i];
                    toSort[i] = toSort[i + 1];
                    toSort[i + 1] = temp;
                    sorted = false;
                }
            }
        }

        System.out.println("After sort: " + Arrays.toString(toSort));
    }

    private void selectionSort(int[] toSort) {
        int min;
        int temp, ind;
        for (int j = 0; j < toSort.length; j++) {
            min = toSort[j];
            ind = j;
            for (int i = j + 1; i < toSort.length; i++) {
                if (min > toSort[i]) {
                    min = toSort[i];
                    ind = i;
                }
            }

            temp = toSort[j];
            toSort[j] = min;
            toSort[ind] = temp;
        }

        System.out.println("After sort: " + Arrays.toString(toSort));

    }

    private void findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }

        System.out.println("Maximal value: " + max);
    }

    private void findMin(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max > array[i]) {
                max = array[i];
            }
        }

        System.out.println("Maximal value: " + max);
    }

    private void sumElements(int[] array) {
        int first = array[0];
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                array[i] = array[i] + first;
            } else {
                array[i] += array[i + 1];
            }
        }

        System.out.println("Sum with next elements " + Arrays.toString(array));
    }

    private void quickSort(int[] toSort) {

    }

    public static void main(String[] args) {
        Sorts sorts = new Sorts();
//        System.out.println("Before sort " + Arrays.toString(sorts.toSortSearch));
//        System.out.println("After sort " + Arrays.toString(sorts.reverseArray(sorts.toSortSearch)));

//        sorts.bubbleSort(new int[]{2,8,4,0,7,1});
//        sorts.selectionSort(new int[]{2, 8, 4, 0, 7, 1});
        sorts.findMax(new int[]{8, 2, 4, 0, 7, 10});
        sorts.sumElements(new int[]{8, 2, 4, 0, 7, 10});

// sorts.binarySearch(2, sorts.toSortSearch);
    }

    public int[] getToSortSearch() {
        return toSortSearch;
    }
}
