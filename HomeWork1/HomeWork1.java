package com.company;

public class HomeWork1 {
    public static void main(String[] args) {
        for(int i = 1; i < 101; i++) {
            var sb = new StringBuilder();
            if(i % 3 == 0) {
                sb.append("Fizz");
                if(i % 5 == 0) {
                    sb.append("Buzz");
                }
            }
            else sb.append(i);
            System.out.println(sb.toString());
        }
    }
}
