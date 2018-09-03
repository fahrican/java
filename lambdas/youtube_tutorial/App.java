package com.teamtreehouse.lambdas.youtube;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class App {

    public static void main(String[] args) {

        List<Person> people = Arrays.asList(

                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carol", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Mathew", "Arnold", 39)
        );

        // 1. sort by last name
        Collections.sort(people, (o1, o2) -> o1.getLastname().compareTo(o2.getLastname()));
        for (Person person : people) {
            System.out.println(person.getLastname());
        }
        System.out.println();

        //2. method print all elements
        printElements(people, value -> true, value -> System.out.println(value));
        System.out.println();


        //3. print elements where last name starts with 'C'
        printElements(people, value -> value.getLastname().startsWith("C"), value -> System.out.println(value));
        System.out.println();

    }

    private static void printElements(List<Person> myList, Predicate<Person> predicate, Consumer<Person> consumer) {

        for (Person person : myList) {

            if (predicate.test(person)) {

                consumer.accept(person);
            }
        }
    }
}
