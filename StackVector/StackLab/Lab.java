package StackVector.StackLab;

import java.util.Deque;
import java.util.ArrayDeque;

/**
 * Stacks follow the LIFO (Last In, First Out) principle, similar to a stack of plates or books.
 * They are useful in algorithms that need to track the order of inserted elements.
 *
 * ArrayDeque provides the functionality of both queues and stacks. A Deque (double-ended queue) 
 * can be thought of as a deck of cards where elements can be added or removed from either end.
 *
 * ArrayDeque can be used to perform stack operations. More details can be found in the official JavaDocs:
 * - ArrayDeque: https://docs.oracle.com/javase/7/docs/api/java/util/ArrayDeque.html
 * - Stack (Deque exhibits the same behavior): https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html
 */
public class Lab {
    /**
     * Creates and returns an instance of a class that implements Deque, such as ArrayDeque, 
     * which provides all the functionality of a Stack. 
     * 
     * This implementation does not use the Stack class, as it has not been updated 
     * since early Java versions. Deques provide the same behavior and are generally preferred.
     *
     * @return A newly instantiated Deque. Deques support both stack and queue operations.
     */
    public Deque<String> createNewStack(){
        return new ArrayDeque<>();
    }

    /**
     * Returns the number of elements currently in the deque.
     *
     * @param stack A Deque of Strings.
     * @return The number of elements in the deque.
     */
    public int getSize(Deque<String> stack){
        return stack.size();
    }

    /**
     * Pushes a value to the top of the deque.
     * (This adds the value to the stack.)
     *
     * @param stack A Deque of Strings.
     * @param item A String to be added to the deque.
     */
    public void addToTopOfStack(Deque<String> stack, String item){
        stack.push(item);
    }

    /**
     * Removes and returns the value from the top of the deque.
     * (This removes the most recently pushed value.)
     *
     * @param stack A Deque of Strings.
     * @return The value removed from the top of the deque.
     */
    public String removeFromTopOfStack(Deque<String> stack){
        return stack.pop();
    }

    /**
     * Peeks at the value on top of the deque without removing it.
     * (This returns the most recently pushed value.)
     *
     * @param stack A Deque of Strings.
     * @return The value at the top of the deque.
     */
    public String getTopOfStackWithoutRemoving(Deque<String> stack){
        return stack.peek();
    }
}