package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
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
     */
    public static void main(String[] args) throws IllegalArgumentException {
        // Check for first argument in command line is exists
        try {
            String temp = args[0];
        } catch (IndexOutOfBoundsException ex) {
            throw new IllegalArgumentException("Argument wasn't received.");
        }
        // Scanner for reading from file
        Scanner in = null;
        try {
             in = new Scanner(new FileInputStream(args[0]), "windows-1251");
        } catch (IOException ex) {
            System.out.println("Путь к файлу содержит ошибку.");
        }
        // Pattern for searching words in file
        Pattern pattern = Pattern.compile("[A-Za-zА-Яа-я]+");
        // Variable for answer
        int answer = 0;

        if (in != null)
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
