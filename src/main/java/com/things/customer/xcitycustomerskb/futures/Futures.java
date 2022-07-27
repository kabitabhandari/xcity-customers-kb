package com.things.customer.xcitycustomerskb.futures;

import org.springframework.scheduling.annotation.Async;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Futures {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Future<String> completableFuture = calculateAsync();
        String result = completableFuture.get();
        System.out.println(result);


        Futures f = new Futures();
        List<Integer> numberList3 = f.calculateAsyncInt().get();
        System.out.println(numberList3);
    }


    // eg 1: creating thread pool
    public static Future<String> calculateAsync(){
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            System.out.println("Sleeping ...");
                Thread.sleep(5000);
            System.out.println("Completed Sleeping :P");

            completableFuture.complete(" >>> Hello");
            return null;
        });

        return completableFuture;
    }

    // eg 2: creating async method
    @Async
    public Future<List<Integer>> calculateAsyncInt(){
        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(33);
        numberList.add(66);

        Future<List<Integer>> intList = CompletableFuture.completedFuture(numberList);
        return intList;

    }



}
