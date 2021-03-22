package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class with entry point for HomeWork4
 * @author ChekhovAI
 */
public class HomeWork4 {
    /**
     * Main method with homework
     * @param args Arguments from command line (terminal)
     * @throws IllegalArgumentException When first argument wasn't received
     * @throws IOException If file is not found or something about it
     */
    public static void main(String[] args) throws IllegalArgumentException, IOException {
        // Check for first argument in command line is exists
        try {
            String temp = args[0];
        } catch (IndexOutOfBoundsException ex) {
            throw new IllegalArgumentException("Argument wasn't received.");
        }
        // Scanner for reading from file
        Scanner in = new Scanner(new FileReader(args[0]));
        // Pattern for searching words in file
        Pattern pattern = Pattern.compile("[A-Za-z]+");
        // Variable for answer
        int answer = 0;
        // Iterate for lines in file
        while (in.hasNextLine()) {
            // Create matcher for searching words in file by pattern
            Matcher matcher = pattern.matcher(in.nextLine());
            // Iterate for found words
            while (matcher.find()) {
                // Increment the answer variable for every word
                answer++;
            }
        }
        // Print answer
        System.out.println(answer);
    }
}
