// Modern method: Deque interface

// The Deque (double-ended queue) interface is a better option for stack-like behavior in modern Java. Deque provides methods to add, remove, and inspect elements from both ends, and it's more efficient and flexible than using a Stack.

// The correct initialization for a stack-like structure using Deque would be:
//      Deque<String> kongCharacters = new ArrayDeque<>();

// Explanation:

// Deque: The Deque interface represents a double-ended queue, meaning you can add/remove elements from both ends. You can use it as a stack (LIFO) by using the push() and pop() methods.
// ArrayDeque: This is a concrete implementation of the Deque interface and is generally the recommended option for stack-like functionality because it does not have the synchronization overhead that Stack has.

package StackVector;

import java.util.Deque;
import java.util.ArrayDeque;

public class StackExampleNewMethod  {

    public static void main(String[] args) {
        // Initialize the Deque for stack-like behavior
        Deque<String> kongCharacters = new ArrayDeque<>();

        // Add elements to the "stack"
        kongCharacters.push("Donkey Kong");
        kongCharacters.push("Diddy Kong");
        kongCharacters.push("Dixie Kong");
        kongCharacters.push("King K. Rool");

        // Print the stack contents
        System.out.println(kongCharacters); // [King K. Rool, Dixie Kong, Diddy Kong, Donkey Kong]

        // Peek at the top element
        System.out.println(kongCharacters.peek()); // King K. Rool

        // Pop the top element
        System.out.println(kongCharacters.pop()); // King K. Rool

        // Print the remaining stack contents
        System.out.println(kongCharacters); // [Dixie Kong, Diddy Kong, Donkey Kong]
    }
}