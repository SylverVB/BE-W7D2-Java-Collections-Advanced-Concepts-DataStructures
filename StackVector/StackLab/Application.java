package StackVector.StackLab;

import java.util.Deque;

public class Application {
    /**
     * This class contains a main method for manually testing stack operations.
     * The test cases should still be executed separately to validate the implementation.
     * All implementation code is located in the Lab class.
     */
    public static void main(String[] args) {
        Lab stackLab = new Lab();
        System.out.println("Was the set properly instantiated? this will print '[]' if yes, null if no");
        Deque<String> myStack = stackLab.createNewStack();
        System.out.println(myStack);

        System.out.println("Can we add 'item 1' to the top of the stack? Now the values are:");
        stackLab.addToTopOfStack(myStack, "item 1");
        System.out.println(myStack);

        System.out.println("Can we add 'item 2' to the top of the stack? Now the values are:");
        stackLab.addToTopOfStack(myStack, "item 2");
        System.out.println(myStack);

        System.out.println("Can we pop off the top of the stack? Now the values are:");
        stackLab.removeFromTopOfStack(myStack);
        System.out.println(myStack);
    }
}