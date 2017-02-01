package com.company.other;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Maciek on 2017-02-01.
 */
public class StackMachine {

    private void compute(String input) {
        Stack<Integer> numbers = new Stack<>();
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                numbers.push(Character.getNumericValue(c));
            } else if (c == '+') {
                int sum = 0;
                while (!numbers.isEmpty()) {
                    sum += numbers.pop();
                }
                numbers.push(sum);
            }
        }
        System.out.println("Result is " + numbers.peek());
    }

    private void computeTwo(String input) {
        Stack<Integer> numbers = new Stack<>();
        int generalSum = 0;
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                numbers.push(Character.getNumericValue(c));
            } else if (c == '+') {
                if (numbers.size() > 1) {
                    int sum = numbers.pop() + numbers.pop();
                    numbers.push(sum);
                }
            }
        }

        while (!numbers.isEmpty()) {
            generalSum += numbers.pop();
        }

        System.out.println("Result: " + generalSum);

    }

    public static void main(String[] args) {
        System.out.println("Enter input");
        StackMachine stackMachine = new StackMachine();
        Scanner input = new Scanner(System.in);
        String in = input.nextLine();
        stackMachine.compute(in);
        stackMachine.computeTwo(in);
    }
}
