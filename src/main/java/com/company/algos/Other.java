package com.company.algos;

import java.util.Scanner;

/**
 * Created by Maciek on 2017-01-27.
 */
public class Other {

    private void doubleArray() {
        int[][] array = new int[3][3];
        Scanner input = new Scanner(System.in);
        String output = "";

        System.out.println("Values in array");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("Put in the value for position [" + i + "][" + j + "]");
                array[i][j] = input.nextInt();
            }
        }
        System.out.println("Values in array");
        for (int i = 0; i < 3; i++) {
            output = "";
            for (int j = 0; j < 3; j++) {
                output = output + array[i][j] + " ";
            }
            System.out.println(output);
        }

    }

    public static void main(String[] args) {
//        "12+34+"
//

//        int n, sum = 0;
//        int[] numbers;
//        System.out.println("Hello put in number of elements");
//        Scanner inp = new Scanner(System.in);
//        Scanner numIn = new Scanner(System.in);
//        n = inp.nextInt();
//        numbers = new int[n];
//        for (int i = 0; i < n; i++) {
//            System.out.println("Put element " + (i + 1));
//            numbers[i] = inp.nextInt();
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (numbers[i] % 2 == 0) {
//                sum += numbers[i];
//            }
//        }
//
//        System.out.println("Sum of numbers is " + sum);
        Other other = new Other();
        other.doubleArray();
    }
}
