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
        for (int i = 0; i <= n/2; i++) {
            temp = toSort[n-i];
            toSort[n-i] = toSort[i];
            toSort[i] = temp;
//            n--;
        }

        return toSort;
    }

    private void binarySearch(int searched, int[] toSearch) {
        int l = 0, r = toSearch.length - 1, mid;
        boolean found = false;
        while(!found){
            mid = (l + r )/ 2;
            if(toSearch[mid] == searched){
                System.out.println("Found searched number on index " + mid);
                found = true;
            } else if(toSearch[mid] < searched){
                r = mid;
            } else if(toSearch[mid] >= searched) {
                l = mid;
            }
        }
    }

    public static void main(String[] args) {
        Sorts sorts = new Sorts();
        System.out.println("Before sort " + Arrays.toString(sorts.toSortSearch));

        System.out.println("After sort " + Arrays.toString(sorts.reverseArray(sorts.toSortSearch)));
//        sorts.binarySearch(2, sorts.toSortSearch);
    }

    public int[] getToSortSearch() {
        return toSortSearch;
    }
}
