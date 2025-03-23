# ArrayList and LinkedList

The `ArrayList` and `LinkedList` classes implement the `List` interface. This means you can perform list-specific operations, as well as the common `Collection` interface operations. Additionally, both classes include their own operations.

## ArrayList

An `ArrayList` is a data structure which contains an array within it, but can resize dynamically. Once it reaches maximum capacity, it will increase its size by copying its elements to a new larger, internal array. The main benefits of using an `ArrayList` are the ability to dynamically add and remove items, access items by index, and iterate over the contents easily.

## LinkedList

A `LinkedList` is a data structure that is internally composed of nodes that contain data and a reference to the next node. A Doubly-Linked List is composed of nodes that contain references to the next and previous node. Java’s implementation of a `LinkedList` implements both the `List` interface and the `Deque` interface, meaning it can act as either a list or a queue. The main advantages of a `LinkedList` are efficient insertion and deletion operations and the ability for it to be used as a foundation for stacks, queues, and other complex data structures.

## Comparison Table

| Feature                                      | **ArrayList**                             | **LinkedList**                                |
|----------------------------------------------|-------------------------------------------|-----------------------------------------------|
| Internal data structure                      | Uses a dynamic array to store elements    | Uses a doubly linked list to store elements   |
| Manipulation speed                           | Slower due to array resizing and shifting | Faster due to node-based structure            |
| Interface implemented                        | Only implements `List`                    | Implements both `List` and `Deque`            |
| Best use case                                | Better for storing and accessing data     | Better for manipulating data                  |
| Memory location of elements                  | Contiguous                                | Non-contiguous                                |

## Resources

- [ArrayList class Java 8 Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)
- [LinkedList class Java 8 Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html)
- [Deque Interface Java 8 Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html)
- [List Interface Java 8 Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)

## Real World Application

### ArrayList:
An `ArrayList` can be used whenever you need a resizable, ordered collection of elements. Here are some real-world examples of how an `ArrayList` can be used in different applications:
- **Caching popular searches:** Search engines can cache popular queries in an `ArrayList` for fast lookups.
- **High score tables:** Games can use an `ArrayList` to maintain a list of top scores, inserting new scores in the right position.
- **Storing user search history:** An `ArrayList` can store the list of recent search keywords entered by a user on a website. New keywords are easily added to the end.

### LinkedList:
A `LinkedList` can be used whenever you need a stack, queue, or other ordered collection of elements. Here are some real-world examples of how lists are used in different applications:
- **Undo/Redo operations in text editors:** A stack stores all text changes, pops them off to undo changes, and pushes them to redo.
- **Live support/chat:** Customer support requests can be put in a queue to be handled by the next available agent.
- **Tab management in browsers:** Open browser tabs can be stored in a deque, allowing users to switch between adjacent tabs from either end.

## Implementation

### Creating an ArrayList and LinkedList

```java
// Creating our collections
ArrayList<Integer> myArrayList = new ArrayList<>();
LinkedList<Integer> myLinkedList = new LinkedList<>();

// Adding elements to our collections
Collections.addAll(myArrayList,
                      1, 2, 3, 4, 5);

Collections.addAll(myLinkedList,
      1, 2, 3, 4, 5);

// Printing our collections
System.out.println(myArrayList); // [1, 2, 3, 4, 5]
System.out.println(myLinkedList); // [1, 2, 3, 4, 5]

// Demonstrating that ArrayLists can resize, unlike arrays
System.out.println(myArrayList.size()); // 5
Collections.addAll(myArrayList,
      6, 7, 8, 9);
System.out.println(myArrayList.size()); // 9
```

### Manipulating an ArrayList and LinkedList

```java
// Using indexes
System.out.println(myArrayList.get(3)); // 4
System.out.println(myLinkedList.indexOf(1)); // 0

// LinkedList-specific operations
  // Deque operations
myLinkedList.addFirst(0);
myLinkedList.addLast(6);
System.out.println(myLinkedList); // [0, 1, 2, 3, 4, 5, 6]

  // Queue operations
System.out.println(myLinkedList.peek()); // 0
myLinkedList.offer(7);
myLinkedList.poll();
System.out.println(myLinkedList); // [1, 2, 3, 4, 5, 6, 7]

  // Stack operations
LinkedList<Integer> myStack = new LinkedList<>();
myStack.push(1);
myStack.push(2);
myStack.push(3);
myStack.push(4);
myStack.push(5);
System.out.println(myStack); // [5, 4, 3, 2, 1]

myStack.push(6);
System.out.println(myStack.peek()); // 6
System.out.println(myStack); // [6, 5, 4, 3, 2, 1]

myStack.pop();
System.out.println(myStack); // [5, 4, 3, 2, 1]
```

Both an `ArrayList` and `LinkedList` implement `List`, meaning we can use list-specific operations, such as retrieving a value at a specific index or retrieving the index of a specific value. Since `LinkedList` also implements the `Deque` interface, we can perform deque, queue, or stack operations as well.

## Summary

- An `ArrayList` is a concrete class that implements `List`. It is a data structure that contains an array within it but can resize dynamically. It is useful for storing ordered elements and accessing elements using an index.
- A `LinkedList` implements both the `List` and `Queue` interfaces, so it has all methods in both interfaces. The data structure is composed of nodes that reference one another. It is useful for manipulating a collection of ordered elements and for creating stacks and queues.