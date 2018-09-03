package com.teamtreehouse.lambdas.youtube;

import java.util.function.BiConsumer;

public class LambdaException {

    public static void main(String[] args) {

        int[] someNumbers = {1, 2, 3, 4};
        int key = 0;

        process(someNumbers, key, wrapperLambda((v, k) -> System.out.println(v / k)));
    }

    private static void process(int[] myArray, int k, BiConsumer<Integer, Integer> biConsumer){

        for (int i : myArray) {
            biConsumer.accept(i, k);
        }
    }

    private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> biConsumer){

        return (v, k) -> {

            try {
                biConsumer.accept(v, k);
            }
            catch (ArithmeticException ae){
                System.out.println("An exception occurred!");
            }
        };
    }
}
