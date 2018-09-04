package com.teamtreehouse.lambdas.youtube;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaStreams {

    public static void main(String[] args) {

        List<Person> people = Arrays.asList(

                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carol", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Mathew", "Arnold", 39)
        );

        people.stream()
            .filter(person -> person.getLastname().startsWith("C"))
            .forEach(System.out::println);
    }

}
