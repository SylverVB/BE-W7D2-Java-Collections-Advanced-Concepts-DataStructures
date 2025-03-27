// Exercises

// Write a single Java program that demonstrates the three different ways to iterate.

package Iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterationExamples {
    public static void main(String[] args) {
        // Create a list
        List<String> list = new ArrayList<>();

        // Add elements to the list
        list.add("people");
        list.add("for");
        list.add("people");

        // 1. Using Enhanced For Loop
        System.out.println("Using Enhanced For Loop:");
        for (String element : list) {
            System.out.println(element);
        }

        // 2. Using forEach() method
        System.out.println("\nUsing forEach() method:");
        list.forEach((element) -> System.out.println(element));

        // 3. Using Iterator
        System.out.println("\nUsing Iterator:");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
    }
}