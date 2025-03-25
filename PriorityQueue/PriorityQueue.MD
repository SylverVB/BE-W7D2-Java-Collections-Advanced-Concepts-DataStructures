# Priority Queue

The Java `PriorityQueue` class is a queue data structure implementation that processes the queue items based on their priorities. Note that `PriorityQueue` is different from other standard queues that implement the FIFO (First-In-First-Out) algorithm.

By default, the priority is determined by objects’ natural ordering. Default priority can be overridden by a `Comparator` provided at queue construction time. A `PriorityQueue` does not permit `null` elements. A `PriorityQueue` relying on natural ordering also does not permit insertion of non-comparable objects (doing so may result in a `ClassCastException`).

The head of this queue is the least element with respect to the specified ordering. If multiple elements are tied for least value, the head is one of those elements -- ties are broken arbitrarily. The queue retrieval operations `poll`, `remove`, `peek`, and `element` access the element at the head of the queue.

A `PriorityQueue` is unbounded but has an internal capacity governing the size of an array used to store the elements on the queue. It is always at least as large as the queue size. As elements are added to a `PriorityQueue`, its capacity grows automatically. The details of the growth policy are not specified.

This class and its iterator implement all of the optional methods of the `Collection` and `Iterator` interfaces. The `Iterator` provided in the `iterator()` method is not guaranteed to traverse the elements of the priority queue in any particular order. If you need ordered traversal, consider using `Arrays.sort(pq.toArray())`.

**Note:** This implementation is not synchronized. Multiple threads should not access a `PriorityQueue` instance concurrently if any of the threads modifies the queue. Instead, use the thread-safe `PriorityBlockingQueue` class.

---

## PriorityQueue Features

- `PriorityQueue` is an unbounded queue that grows dynamically.
- The default initial capacity is `11`, which can be overridden using the `initialCapacity` parameter in the appropriate constructor.
- It does not allow `null` objects.
- The queue items must be `Comparable` to determine their priorities.
- By default, the items in the `PriorityQueue` are ordered in natural order.
- A `Comparator` can be used for custom ordering of objects in the queue.
- A `PriorityQueue` relying on natural ordering does not permit insertion of non-comparable objects (doing so may result in a `ClassCastException`).
- The queue retrieval operations `poll`, `remove`, `peek`, and `element` access the element at the head of the queue.
- The head of the `PriorityQueue` is the least element based on the natural ordering or the `Comparator` based ordering.
- If multiple objects have the same priority, the queue can poll any one of them arbitrarily.
- `PriorityQueue` is not thread-safe. Use `PriorityBlockingQueue` in concurrent environments.
- It provides **O(log(n))** time performance for `add()` and `poll()` methods.
- The `Iterator` provided by the method `iterator()` is not guaranteed to traverse the elements of the priority queue in any particular order. If you need ordered traversal, consider using `Arrays.sort(pq.toArray())`.

---

## PriorityQueue Constructors

The `PriorityQueue` class provides 6 different ways to construct a priority queue in Java:

1. **`PriorityQueue()`**  
   Constructs an empty queue with the default initial capacity (`11`) that orders its elements according to their natural ordering.
2. **`PriorityQueue(Collection c)`**  
   Constructs a queue containing the elements in the specified collection.
3. **`PriorityQueue(int initialCapacity)`**  
   Constructs an empty queue with the specified initial capacity that orders its elements according to their natural ordering.
4. **`PriorityQueue(int initialCapacity, Comparator comparator)`**  
   Constructs an empty queue with the specified initial capacity that orders its elements according to the specified comparator.
5. **`PriorityQueue(PriorityQueue c)`**  
   Creates a priority queue containing the elements in the specified priority queue. The elements are ordered according to their natural ordering.
6. **`PriorityQueue(SortedSet c)`**  
   Creates a priority queue containing the elements in the specified sorted set. The elements are ordered according to their natural ordering.

---

## PriorityQueue Methods

### Adding Items
- **`boolean add(object)`**: Inserts the specified element into this priority queue. If the queue is full, it throws an exception.
- **`boolean offer(object)`**: Inserts the specified element into this priority queue. If the queue is full, it returns `false`.

### Accessing Items
- **`Object element()`**: Retrieves, but does not remove, the head of this queue, or throws `NoSuchElementException` if this queue is empty.
- **`Object peek()`**: Retrieves, but does not remove, the head of this queue, or returns `null` if this queue is empty.

### Removing Items
- **`boolean remove(object)`**: Removes a single instance of the specified element from this queue, if it is present.
- **`Object poll()`**: Retrieves and removes the head of this queue, or returns `null` if this queue is empty.
- **`void clear()`**: Removes all elements from this priority queue.

### Other Methods
- **`Comparator comparator()`**: Returns the comparator used to order the elements in this queue, or `null` if this queue is sorted according to the natural ordering of its elements.
- **`boolean contains(Object o)`**: Returns `true` if this queue contains the specified element.
- **`Iterator iterator()`**: Returns an iterator over the elements in this queue.
- **`int size()`**: Returns the number of elements in this queue.
- **`Object[] toArray()`**: Returns an array containing all elements in this queue.

---

## Real-World Applications

A **Priority Queue** is different from a normal queue because, instead of being “first-in-first-out,” values are dequeued based on priority. It is an abstract data type that represents a container where elements have priorities attached. An element of the highest priority is always dequeued first, and if removed, the next highest priority element advances to the front.

A **priority queue** is typically implemented using a **Heap** data structure.

### Applications of Priority Queue

1. **Dijkstra’s Shortest Path Algorithm**: Used to extract the minimum efficiently while implementing the algorithm for graphs stored as adjacency lists or matrices.
2. **Prim’s Algorithm**: Implements Prim’s Algorithm to store node keys and extract the minimum key node at each step.
3. **Data Compression**: Used in Huffman coding to compress data.
4. **Artificial Intelligence (A* Search Algorithm)**: Finds the shortest path between vertices of a weighted graph. The priority queue (fringe) tracks unexplored routes, prioritizing the smallest lower-bound path length.
5. **Heap Sort**: Implemented using a Heap, a type of Priority Queue.
6. **Operating Systems**: Used for load balancing (e.g., server load management) and interrupt handling.

---

## Implementation Example

The following example demonstrates basic operations of a priority queue, such as adding, peeking, and polling elements.

```java
// Java program to demonstrate the working of PriorityQueue
import java.util.*;

class PriorityQueueDemo {
    public static void main(String args[]) {
        // Creating an empty priority queue
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        // Adding items to the priority queue
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(15);

        // Accessing and printing the top element
        System.out.println("Peek: " + pQueue.peek());

        // Removing and printing the top element
        System.out.println("Poll: " + pQueue.poll());

        // Printing the top element again
        System.out.println("Peek after poll: " + pQueue.peek());
    }
}
```

**Output**:
```
Peek: 10
Poll: 10
Peek after poll: 15
```

---

## Operations on Priority Queue

### Adding Elements

The `add()` method inserts elements into the priority queue in ascending priority order by default.

```java
import java.util.*;

public class PriorityQueueDemo {
    public static void main(String args[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < 3; i++) {
            pq.add(i);
            pq.add(1);
        }

        System.out.println(pq);
    }
}
```

**Output**:
```
[0, 1, 1, 1, 2, 1]
```

We will not get sorted elements by printing PriorityQueue. If we want the elements of the PriorityQueue to appear in sorted order, we need to repeatedly remove the elements using `poll()` (which **retrieves and removes the smallest element**) and store them elsewhere.

#### Example: Iterating in Sorted Order

Here’s how you can extract and print elements in sorted order:

```java
import java.util.*;

public class PriorityQueueDemo {
    public static void main(String args[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < 3; i++) {
            pq.add(i);
            pq.add(1);
        }
        System.out.println("Heap representation: " + pq);

        System.out.print("Sorted order: ");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }
}
```

**Output**:
```
Heap representation: [0, 1, 1, 1, 2, 1]
Sorted order: 0 1 1 1 1 2
```

### Removing Elements

The `remove()` method removes the first occurrence of an element, and `poll()` removes and returns the head of the queue.

```java
import java.util.*;

public class PriorityQueueDemo {
    public static void main(String args[]) {
        PriorityQueue<String> pq = new PriorityQueue<>();

        pq.add("Gators");
        pq.add("For");
        pq.add("Gators");

        System.out.println("Initial PriorityQueue: " + pq);

        // Removing an element
        pq.remove("Gators");
        System.out.println("After Remove: " + pq);

        // Polling the top element
        System.out.println("Poll Method: " + pq.poll());

        System.out.println("Final PriorityQueue: " + pq);
    }
}
```

**Output**:
```
Initial PriorityQueue: [For, Gators, Gators]
After Remove: [For, Gators]
Poll Method: For
Final PriorityQueue: [Gators]
```

### Accessing Elements

Since Queue follows the First In First Out principle, we can access only the head of the queue. To access elements from a priority queue, we can use the peek() method. The `peek()` method retrieves the head of the queue without removing it.

```java
import java.util.*;

class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("Gators");
        pq.add("For");
        pq.add("Gators");

        System.out.println("PriorityQueue: " + pq);
        System.out.println("Accessed Element: " + pq.peek());
    }
}
```

**Output**:
```
PriorityQueue: [For, Gators, Gators]
Accessed Element: For
```

When you call `System.out.println(pq)`, the PriorityQueue's `toString()` implementation converts the internal heap structure into an array and prints it. This array representation may appear sorted in small examples because of how the heap organizes elements in a partial order:

- For small inputs, the heap structure may look sorted because there are few levels of the binary tree.
- In larger heaps, the printed representation is less likely to appear sorted.

## Iterating Through `PriorityQueue`

There are multiple ways to iterate through a `PriorityQueue` in Java. The most common approaches include:

1. **Using the `iterator()` method:**  
   The `PriorityQueue` provides a built-in iterator that allows traversal of its elements.  
   However, **the `iterator()` does not guarantee traversal in any specific order, such as priority or sorted order.**

2. **Converting to an array and traversing:**  
   Converting the queue to an array using the `toArray()` method allows you to traverse or sort the elements as needed.

3. **Using the `poll()` method:**  
   To retrieve elements in priority order, repeatedly use `poll()`, which removes and returns the smallest element in the queue based on its priority.

---

### Example 1: Using `iterator()`

```java
import java.util.*;

public class PriorityQueueDemo {
    public static void main(String args[]) {
        PriorityQueue<String> pq = new PriorityQueue<>();

        pq.add("Gators");
        pq.add("For");
        pq.add("Gators");

        Iterator<String> iterator = pq.iterator();

        // Iterating using the built-in iterator
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
```

**Output:**
```
For Gators Gators
```

---

### Explanation of `iterator()`:
The `iterator()` method of a `PriorityQueue` works as follows:

1. **Traversal Order Not Guaranteed:**  
   The elements are traversed based on the internal heap structure, not in sorted or priority order.

2. **Heap-based Order:**  
   Since the `PriorityQueue` uses a binary heap internally, the iteration reflects its internal arrangement.

3. **To Retrieve Elements in Priority Order:**  
   Use `poll()` to ensure elements are retrieved in the correct priority order.

---

### Example 2: Iterating and Retrieving in Priority Order

```java
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(5);
        pq.add(15);

        // Iterating over the priority queue
        System.out.println("Iteration:");
        for (Integer num : pq) {
            System.out.println(num); // Order is not guaranteed to be sorted
        }

        // Retrieving in priority order
        System.out.println("Priority order using poll:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll()); // Prints elements in ascending order
        }
    }
}
```

**Output:**

The `iterator()` might produce:
```
Iteration:
5
10
15
```

But using `poll()` ensures priority order:
```
Priority order using poll:
5
10
15
```

---

### Example 3: Converting to Array and Sorting

If you need the elements in sorted order without modifying the `PriorityQueue`, convert it to an array and sort it:

```java
import java.util.*;

public class PriorityQueueArraySort {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(30);
        pq.add(10);
        pq.add(20);

        // Convert to array and sort
        Object[] sortedArray = pq.toArray();
        Arrays.sort(sortedArray);

        // Print sorted array
        System.out.println("Sorted Array:");
        for (Object num : sortedArray) {
            System.out.println(num);
        }
    }
}
```

**Output:**
```
Sorted Array:
10
20
30
```

---

### `iterator()` Method Summary:
1. **`iterator()`** provides no guarantees about traversal order. Use it when order isn't critical.
2. **`poll()`** retrieves elements in priority order by removing them from the queue.
3. **`toArray()` and `Arrays.sort()`** allow you to retrieve elements in sorted order without modifying the queue.

---

## `PriorityQueue` Summary

The `PriorityQueue` class is a data structure implementation that processes elements based on their priorities, unlike standard queues which typically use the FIFO (First-In-First-Out) algorithm.

### Key Features:
- **Priority-Based Processing:**
  - The elements in a `PriorityQueue` are ordered according to their **natural ordering** or by a **Comparator** provided at the time of queue construction.
  - The **head of the queue** is the least element (based on the specified ordering). If multiple elements share the same priority, ties are broken arbitrarily.

- **Performance:**
  - Operations such as `add()` and `poll()` offer **O(log(n))** performance, as the queue maintains its heap structure internally.

- **Capacity Management:**
  - A `PriorityQueue` is unbounded, but its internal capacity governs the size of the array used to store elements. The capacity grows automatically as new elements are added, though the details of the growth policy are unspecified.

- **Iterator Behavior:**
  - The iterator provided by the `iterator()` method does **not guarantee traversal in any particular order** (e.g., sorted or priority order). The traversal order reflects the internal heap structure.
  - To retrieve elements in priority order, repeatedly use the `poll()` method or convert the queue to an array and sort it using `Arrays.sort()`.

- **Thread Safety:**
  - `PriorityQueue` is **not thread-safe**. For concurrent access, use `PriorityBlockingQueue`, which provides a thread-safe alternative.

### Summary Points:
1. A `PriorityQueue` processes elements based on priorities rather than insertion order.
2. Supports natural ordering or custom comparators for element prioritization.
3. Not suitable for concurrent use—consider `PriorityBlockingQueue` for multithreaded environments.