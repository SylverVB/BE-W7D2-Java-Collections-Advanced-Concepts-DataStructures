# Stacks and Vector

## Description

### Vector

The Vector class implements a growable array of objects. Like an array, it contains components that can be accessed using an integer index. However, the size of a Vector can grow or shrink as needed to accommodate adding and removing items after the Vector has been created.

Each vector tries to optimize storage management by maintaining a capacity and a capacityIncrement. The capacity is always at least as large as the vector size; it is usually larger because as components are added to the vector, the vector's storage increases in chunks the size of capacityIncrement. An application can increase the capacity of a vector before inserting a large number of components; this reduces the amount of incremental reallocation.

The iterators returned by this class's iterator and listIterator methods are fail-fast: if the vector is structurally modified at any time after the iterator is created, in any way except through the iterator's own remove or add methods, the iterator will throw a ConcurrentModificationException. Thus, in the face of concurrent modification, the iterator fails quickly and cleanly, rather than risking arbitrary, non-deterministic behavior at an undetermined time in the future. The Enumerations returned by the elements method are not fail-fast.

Note that the fail-fast behavior of an iterator cannot be guaranteed as it is, generally speaking, impossible to make any hard guarantees in the presence of unsynchronized concurrent modification. Fail-fast iterators throw ConcurrentModificationException on a best-effort basis. Therefore, it would be wrong to write a program that depended on this exception for its correctness: the fail-fast behavior of iterators should be used only to detect bugs.

As of the Java 2 platform v1.2, this class was retrofitted to implement the List interface, making it a member of the Java Collections Framework. Unlike the new collection implementations, Vector is synchronized. If a thread-safe implementation is not needed, it is recommended to use ArrayList in place of Vector.

### Stack

The Stack class represents a last-in-first-out (LIFO) stack of objects. It extends class Vector with five operations that allow a vector to be treated as a stack. The usual push and pop operations are provided, as well as a method to peek at the top item on the stack, a method to test for whether the stack is empty, and a method to search the stack for an item and discover how far it is from the top. When a stack is first created, it contains no items.

A more complete and consistent set of LIFO stack operations is provided by the Deque interface and its implementations, which should be used in preference to this class.

In the following example, we have created an instance of the Stack class. After that, we have invoked the empty() method two times. The first time it returns true because we have not pushed any element into the stack. After that, we have pushed elements into the stack. Again we have invoked the empty() method that returns false because the stack is not empty.

```java
import java.util.Stack;

public class StackEmptyMethodExample
{
    public static void main(String[] args)
    {
        // Creating an instance of Stack class
        Stack<Integer> stk = new Stack<>();
        
        // Checking stack is empty or not
        boolean result = stk.empty();
        System.out.println("Is the stack empty? " + result);

        // Pushing elements into stack
        stk.push(78);
        stk.push(113);
        stk.push(90);
        stk.push(120);

        // Prints elements of the stack
        System.out.println("Elements in Stack: " + stk);
        
        result = stk.empty();
        System.out.println("Is the stack empty? " + result);
    }
}
```

**Output:**

```
Is the stack empty? true
Elements in Stack: [78, 113, 90, 120]
Is the stack empty? false
```

### Stack Class push() and pop() Methods

The push() method inserts an item onto the top of the stack. It works the same as the method addElement(item) method of the Vector class. It passes a parameter item to be pushed into the stack. The pop() method removes an object at the top of the stack and returns the same object. It throws EmptyStackException if the stack is empty.

Let's implement the stack in a Java program and perform push and pop operations.

```java
import java.util.*;

public class StackPushPopExample
{
    public static void main(String args[])
    {
        // Creating an object of Stack class
        Stack<Integer> stk = new Stack<>();
        System.out.println("stack: " + stk);

        // Pushing elements into the stack
        pushelmnt(stk, 20);
        pushelmnt(stk, 13);
        pushelmnt(stk, 89);
        pushelmnt(stk, 90);
        pushelmnt(stk, 11);
        pushelmnt(stk, 45);
        pushelmnt(stk, 18);

        // Popping elements from the stack
        popelmnt(stk);
        popelmnt(stk);

        // Throws exception if the stack is empty
        try
        {
            popelmnt(stk);
        }
        catch (EmptyStackException e)
        {
            System.out.println("empty stack");
        }
    }

    // Performing push operation
    static void pushelmnt(Stack stk, int x)
    {
        // Invoking push() method
        stk.push(new Integer(x));
        System.out.println("push -> " + x);

        // Prints modified stack
        System.out.println("stack: " + stk);
    }

    // Performing pop operation
    static void popelmnt(Stack stk)
    {
        System.out.print("pop -> ");

        // Invoking pop() method
        Integer x = (Integer) stk.pop();
        System.out.println(x);

        // Prints modified stack
        System.out.println("stack: " + stk);
    }
}
```

**Output:**

```
stack: []
push -> 20
stack: [20]
push -> 13
stack: [20, 13]
push -> 89
stack: [20, 13, 89]
push -> 90
stack: [20, 13, 89, 90]
push -> 11
stack: [20, 13, 89, 90, 11]
push -> 45
stack: [20, 13, 89, 90, 11, 45]
push -> 18
stack: [20, 13, 89, 90, 11, 45, 18]
pop -> 18
stack: [20, 13, 89, 90, 11, 45]
pop -> 45
stack: [20, 13, 89, 90, 11]
pop -> 11
stack: [20, 13, 89, 90]
```

## Real World Application

Here are some different applications of the stack data structure in computer science:

- Memory management
- Function calls, particularly recursive function calls
- String reversal
- Parenthesis checking
- Syntax parsing
- Matching HTML tags in web development
- Arithmetic expression evaluation

## Implementation

Below is an example of implementing a stack:

```java
public class Stack {

    private int lastItem = 0;
    private int[] items = new int[0];

    // Add items to the stack
    public void push(int newItem) {

    }

    // Remove items from the stack
    public int pop() {
        return 0;
    }

    // View last item
    public int peek() {
        return 0;
    }
}
```

We'll use this basic structure to keep track of the last item we've added and an array to manage all of the items.

Notice we've initialized our items array to be 0 items long. You'll see why we did this shortly.

### Implementing Push

The first thing we'll do is implement the push() functionality. Push is used to add an item to the stack and update the lastItem to the one we're pushing.

To add an item to the array we'll simply add the new item (defined by the parameter) to the end of the items array. But...how do you know where the end of the array is? Since we initialized it with a length of zero, what we can do is use the length property to find the end. In addition to that, though, we must increase the length of our array so that we can actually fit some items within it. If we increase it by 1, that'll suffice to fit in our new 1 item.

So our code can look like this:

```java
public void push(int newItem){
   int index = items.length; // Get current length to store as index
   items = new int[items.length + 1];  // Increase the array by 1 so that we can add our new item
   items[index] = newItem; // Store the value in the index

   lastItem = newItem; // Update lastItem
}
```

### Implementing Pop

Adding items to the Stack is great, but we'll also need to be able to remove items so that we can do a little bit of testing of our code. You'll find that our current approach to a Stack may be challenging to support.

For instance, we have a reference to the last item, but we can't simply return that. We need to remove it entirely from the array. Arrays are fixed-sized objects in Java, so that means we'll have to copy over all of the elements to a new array and get rid of the old one.

Adding the following code to our class:

```java
public int pop(){
  int tempItem = lastItem; // Store the last item into a variable
  
   // Copy a new array but remove last item
   int[] newArray = new int[items.length-1];

   for(int i = 0; i < newArray.length; i++){
     newArray[i] = items[i];
  }

   items = newArray; // Update the items array
   lastItem = items[items.length-1]; // Update lastItem

   // Return our ‘popped' element
   return tempItem;
}
```

Now we can test our code a bit.

### Testing your Stack

We will create a new class in our project called `TestStack`. Adding the following contents to `TestStack`:

```java
public class TestStack {

  public static void main(String[] args) {
    Stack stack = new Stack();

    stack.push(1);
    stack.push(2);

    int value = stack.pop();

    System.out.println(value);
    System.out.println(value);
  }
}
```

Essentially, we'll try adding two values to the stack and then popping them off. What happens when we run the code?

The console prints out `2` twice! Why is that?

Just looking at our code, you may already have an inclination. However, imagine that you really weren't sure (and maybe you're not). Then you should start by examining how each of our methods accomplish their tasks.

Thus, let's re-examine the `push()` method first. One simple approach to debugging our issue is to use `System.out.println(...)` statements to verify our assumed values.

We will update our push method to the code below, which adds `println()` statements after each time we alter any data.

```java
public void push(int newItem) {
  int index = items.length; // Get current length to store as index
  System.out.println("The array length is: " + index);

  items = new int[items.length + 1]; // Increase the array by 1 
  System.out.println("items after extending the length by 1: " + Arrays.toString(items));

  items[index] = newItem; // Store the value in the index
  System.out.println("items after storing the new value: " + Arrays.toString(items));

  lastItem = newItem; // Update lastItem
  System.out.println("The last item: " + lastItem);
}
```

When we re-run the `TestStack` class, what do we see on the console?

The first line is fine, but then the second line has this interesting output that starts with a left bracket `[`. Recall that arrays are objects, and printing an object defaults to its memory location. So what is displayed on the console is actually a memory address.

A simple shortcut that we'll show you is to use the `Arrays` class and call the `Arrays.toString(...)` method. This method will convert the contents of an array to a String.

Updating our code to use `Arrays.toString(...)`:

```java
public void push(int newItem) {
  int index = items.length; // Get current length to store as index
  System.out.println("The array length is: " + index);

  items = new int[items.length + 1]; // Increase the array by 1
  System.out.println("items after extending the length by 1: " + Arrays.toString(items));

  items[index] = newItem; // Store the value in the index
  System.out.println("items after storing the new value: " + Arrays.toString(items));

  lastItem = newItem; // Update lastItem
  System.out.println("The last item: " + lastItem);
}
```

When we re-run the `TestStack` class, we'll see output like the following:

```
The array length is: 0
items after extending the length by 1: [0]
items after storing the new value: [2]
The last item: 2
```

Highlighted in red we have a particular issue. The value printed is `[0, 0]` and then `[0, 2]`. This indicates that our array is not saving any previous values! Upon further inspection of the code, we can see that instead of copying the values of the array when we extend it by one element, we merely create a new array which will default to having all 0's as elements.

### Summary 

- **The Vector class** implements a growable array of objects. Like an array, it contains components that can be accessed using an integer index. However, the size of a Vector can grow or shrink as needed to accommodate adding and removing items after the Vector has been created.
  - As of the Java 2 platform v1.2, this class was retrofitted to implement the `List` interface, making it a member of the Java Collections Framework.
  - Unlike the new collection implementations, Vector is synchronized.
  - If a thread-safe implementation is not needed, it is recommended to use `ArrayList` in place of `Vector`.

- **The Stack class** represents a last-in-first-out (LIFO) stack of objects. It extends the class `Vector` with five operations that allow a vector to be treated as a stack. The usual push and pop operations are provided, as well as a method to peek at the top item on the stack, a method to test for whether the stack is empty, and a method to search the stack for an item and discover how far it is from the top.
  - When a stack is first created, it contains no items.
  - A more complete and consistent set of LIFO stack operations is provided by the `Deque` interface and its implementations, which should be used in preference to this class.