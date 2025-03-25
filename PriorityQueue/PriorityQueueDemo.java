package PriorityQueue;

// Exercise

// Write a program that takes five random United States, adds them to a Priority Queue in a random order, and then outputs the states in alphabetical order.

import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        // Array of all 50 U.S. states
        String[] states = {
            "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", 
            "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", 
            "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", 
            "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", 
            "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", 
            "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", 
            "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"
        };

        // Priority Queue to store the states (ordered alphabetically by default)
        PriorityQueue<String> pq = new PriorityQueue<>();

        // Random object to select random states
        Random random = new Random();

        // Add 5 random states to the PriorityQueue
        for (int i = 0; i < 5; i++) {
            int randomIndex = random.nextInt(states.length);
            pq.add(states[randomIndex]);
        }

        // Output the PriorityQueue (states in alphabetical order)
        System.out.println("States in alphabetical order:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}

// Explanation:
// 1. The program stores all 50 U.S. states in an array.
// 2. A `Random` object selects five random states from the array.
// 3. These states are added to a `PriorityQueue`, which maintains them in alphabetical order (since `String` implements the `Comparable` interface and uses lexicographical ordering).
// 4. Finally, the program retrieves and prints the states in alphabetical order by repeatedly calling `poll()` on the `PriorityQueue`.

// Sample Output:

// States in alphabetical order:
// Arizona
// California
// Hawaii
// Montana
// Texas

// Each run will produce a different set of states due to the random selection. However, the output will always be in alphabetical order.