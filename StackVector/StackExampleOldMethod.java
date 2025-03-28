// Old method: Stack

// The Stack class in Java was part of the original version of the Java Collections Framework, but it has been considered somewhat outdated and is generally not recommended for new development because it extends Vector and has some performance drawbacks. The Stack class is synchronized, which can be a disadvantage when you're dealing with multi-threaded applications that don't need synchronization.

package StackVector;

import java.util.Stack;

public class StackExampleOldMethod {

    public static void main(String[] args) {
        // Prints welcome message
        System.out.println("Stacks");

        // FILO: First in, last out.
        // Or LIFO: Last In, First Out (Like a stack of pancakes).
        Stack<String> kongCharacters = new Stack<>();

        // Add elements to the stack
        kongCharacters.push("Donkey Kong");
        kongCharacters.push("Diddy Kong");
        kongCharacters.push("Dixie Kong");
        kongCharacters.push("King K. Rool");
        kongCharacters.push("Candy Kong");
        kongCharacters.push("Donkey Kong Jr");
        kongCharacters.push("Tiny Kong");
        kongCharacters.push("Cranky Kong");

        // Print the stack contents
        System.out.println(kongCharacters);
        // Expected Output:
        // [Donkey Kong, Diddy Kong, Dixie Kong, King K. Rool, Candy Kong, Donkey Kong Jr, Tiny Kong, Cranky Kong]

        // Returns the number of objects in the stack
        System.out.println("\nNumber of objects in the stack: " + kongCharacters.size());
        // Expected Output:
        // Number of objects in the stack: 8

        // Looks at the object at the top of the stack without removing it
        System.out.println("\nObject at the top: " + kongCharacters.peek());
        // Expected Output:
        // Object at the top: Cranky Kong

        // Searches for a specific element, by distance from the top of the Stack.
        // This method returns the distance from the top of the Stack with the top element being distance 1
        System.out.println("\nDistance from top of the stack to 'Candy Kong': " + kongCharacters.search("Candy Kong"));
        // Expected Output:
        // Distance from top of the stack to 'Candy Kong': 5

        // Removes the object from the top of the stack and returns it.
        System.out.println("\nPopped object: " + kongCharacters.pop());
        // Expected Output:
        // Popped object: Cranky Kong

        // Prints remaining stack contents after popping an element
        System.out.println("\nRemaining stack: " + kongCharacters);
        // Expected Output:
        // [Donkey Kong, Diddy Kong, Dixie Kong, King K. Rool, Candy Kong, Donkey Kong Jr, Tiny Kong]

        // Tests if the stack is empty and returns true if it is
        System.out.println("\nPopping all elements from the stack:");

        while (!kongCharacters.empty()) {
            System.out.println(kongCharacters.pop());
        }
        // Expected Output:
        // Popped object: Tiny Kong
        // Popped object: Donkey Kong Jr
        // Popped object: Candy Kong
        // Popped object: King K. Rool
        // Popped object: Dixie Kong
        // Popped object: Diddy Kong
        // Popped object: Donkey Kong

        System.out.println("\nStack is now empty.");
        // Expected Output:
        // Stack is now empty.
    }
}