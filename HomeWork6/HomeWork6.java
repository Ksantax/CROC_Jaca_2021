package com.company;

import java.util.Scanner;
import java.util.Stack;

/**
 * Class with entry point
 * @author  ChekhovAI
 */
public class HomeWork6 {
    /**
     * Entry point of program
     * Gets a path way from stdin and print normalized version of it
     * @param args console args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Getting the path and splitting for each folder transition
        String[] transitions = in.nextLine().split("\\\\");
        // Making stack for easy processing transitions
        Stack<String> stack = new Stack<>();
        // Making answer variable
        StringBuilder ans = new StringBuilder();
        // Iterating for each transition
        for (String transition : transitions) {
            // If transition is standing still do nothing
            if (transition.equals(".")) continue;
            // If transition is backstep
            if (transition.equals("..")) {
                // If have logged transition delete it
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                // Else save the backstep
                else {
                    ans.append(transition);
                    ans.append("\\");
                }
            }
            // Else log transition
            else {
                stack.add(transition);
            }
        }

        // Now in stack all not useless transitions without backsteps
        // All backsteps already in answer

        // Adding transitions to answer
        for (String transition : stack) {
            ans.append(transition);
            ans.append("\\");
        }
        // Printing answer
        System.out.println(ans.toString().substring(0, ans.length() - 1));
    }
}
