package com.things.customer.xcitycustomerskb.futures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Futures2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = completableFuture.thenApply(s -> s + " World");
        System.out.println(future2.get());




    }

}
