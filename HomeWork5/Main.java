package com.company;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Стартовый класс.
 */
public class Main {

    /**
     * Пример входной строки.
     */
    public static final String INPUT_STRING = "Невежество есть мать промышленности, как и суеверий." +
            " Сила размышления и воображения подвержена ошибкам; но привычка двигать рукой или ногой" +
            " не зависит ни от того, ни от другого. Поэтому мануфактуры лучше всего процветают там, где" +
            " наиболее подавлена духовная жизнь, так что мастерская может рассматриваться как машина," +
            " части которой составляют люди.";

    /**
     * Шаблон поиска символов в строке.
     */
    public static final String TEMPLATE = " ";

    /**
     * Переменная для ответа
     */
    public final static AtomicInteger sum = new AtomicInteger(0);

    /**
     * Точка входа в приложение.
     * Мы будем запускать сравнение каждого сивола в отдельном потоке,
     * но количество работающих потоков в приложении будет ограничено.
     * Каждое сравнение будем назвать <i>task<i/>
     * @param args аргументы командной строки.
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long current = System.currentTimeMillis();

        // Main code
        // Making ExecutorService to control pool of thread
        /* We can use number of cores for setting threads pool size:
        int threads = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(threads);
         */
        //But we will use this one because our tasks are not CPU intensive
        ExecutorService service = Executors.newFixedThreadPool(100);
        // List for Futures. We will need them to be ensure that all tasks will be completed
        ArrayList<Future> futures = new ArrayList<>();
        // Make tasks for every character in INPUT_STRING and submit them to ExecutorService
        for (int i = 0; i < INPUT_STRING.length(); i++) {
            // We need a variable for each task to exclude multithreaded taking
            // the position of the character in the string
            int finalI = i;
            // Submit task and get Future from it
            futures.add(service.submit(() -> {
                // Conventional realization
                if (Matcher.match(String.valueOf(INPUT_STRING.charAt(finalI)), TEMPLATE)) {
                    sum.getAndIncrement();
                }
            }));
        }
        // .get() from every Future to be ensure that tasks are completed
        for (Future future : futures) future.get();
        // Shutdown service
        service.shutdown();


        System.out.println("Count of space: " + sum);
        System.out.println("Time: " + (System.currentTimeMillis() - current) / 1000 + " c.");
    }
}
