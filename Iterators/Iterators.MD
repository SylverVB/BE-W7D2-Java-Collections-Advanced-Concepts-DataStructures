# Iterators

## Description

### Iterable and Iterator Interface

The `Iterable` interface defines a data structure that can be directly traversed using the `.iterator()` method, which returns an `Iterator`. This provides fine-grained control over iteration.

The `Iterator` interface contains methods for traversal:

- **hasNext()**: Returns `false` if there are no more elements; otherwise, `true`.
- **next()**: Returns the next element in the collection.
- **remove()**: Removes the last returned element.
- **forEachRemaining()**: Performs the given action for each remaining element in the collection.

Example:
```java
List<String> names = new ArrayList<>();
// add names...
Iterator<String> it = names.iterator();
while (it.hasNext()) {
    String name = it.next();
    doSomething(name);
}
```

---

### Enhanced For Loop

Any object implementing the `Iterable` interface can be iterated using an "enhanced" for loop:
```java
List<String> names = new ArrayList<>();
// add names...
for (String name : names) {
    System.out.println(name);
}
```

#### Key Points:
- Simplified syntax for straightforward iterations.
- Does not track the index or provide fine-grained control over execution.

---

### Differences Between `Iterable` and `Iterator`

| Feature                         | `Iterable`                                  | `Iterator`                                   |
|---------------------------------|---------------------------------------------|---------------------------------------------|
| **Definition**                  | Represents a collection that can be traversed. | Interface allowing traversal over a collection. |
| **Usage**                       | Implemented by a class to allow `for-each` and `iterator()`. | Provides methods (`hasNext()`, `next()`, etc.) for iteration. |
| **State Management**            | Does not maintain state.                    | Maintains the iteration state.              |
| **Methods**                     | `iterator()` method to get an `Iterator`.    | `hasNext()`, `next()`, `remove()`, and `forEachRemaining()`. |
| **Custom Logic**                | No direct custom logic for iteration.       | Allows implementation of custom traversal logic. |
| **Modification**                | Cannot modify elements during iteration.    | Allows removal of elements using `remove()`. |

---

## Real World Applications

- **Standardized Interface**: Provides a uniform way to traverse collections.
- **Safe Iteration**: Detects and prevents issues during concurrent modifications.
- **Enhanced For-loop Integration**: Simplifies iteration syntax.
- **Custom Collections**: Allows custom logic for traversal in user-defined collections.

---

## Implementation

### Using Enhanced For Loop
Objects of classes implementing the `Collection` interface can be iterated with a for-each loop.

```java
import java.util.*;

class IterateUsingEnhancedForLoop {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("people");
        list.add("for");
        list.add("people");

        for (String element : list) {
            System.out.println(element);
        }
    }
}
```

---

### Using `forEach()` Method
The `forEach()` method accepts a lambda expression as a parameter to perform an action for each element.

```java
import java.util.*;

class IterateUsingForEach {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("people");
        list.add("for");
        list.add("people");

        list.forEach(element -> System.out.println(element));
    }
}
```

---

### Using Iterator
Java `Iterator` provides methods for fine-grained control over iteration.

```java
import java.util.*;

class IterateUsingIterator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("people");
        list.add("for");
        list.add("people");

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
    }
}
```

---

## Summary

1. The `Iterable` interface allows objects to be traversed using `iterator()` or enhanced for loops.
2. The `Iterator` interface provides methods for iteration, offering more control (e.g., removal of elements).
3. Enhanced for loops simplify syntax but lack fine-grained control over traversal.
4. The `forEach()` method (Java 8+) provides a lambda-based approach for iterating over elements.
5. Iterators are stateful, allowing advanced traversal techniques and modifications during iteration.