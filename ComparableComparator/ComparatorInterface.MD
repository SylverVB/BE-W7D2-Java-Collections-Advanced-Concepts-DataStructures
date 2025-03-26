# Comparator Interface

The `Comparator` interface in Java is a powerful tool for defining custom sorting logic, especially when the objects being sorted do not have a natural ordering or when a different ordering is required for specific use cases.

#### Overview
A `Comparator` is a comparison function that imposes a total ordering on a collection of objects. It is primarily used to:

1. **Sort Collections or Arrays**: The `Comparator` can be passed to sorting methods such as `Collections.sort` or `Arrays.sort` to customize the sort order.
2. **Control the Order of Data Structures**: Data structures like `TreeSet` or `TreeMap` can use a `Comparator` to maintain a specific order.
3. **Order Non-Naturally Ordered Objects**: It provides a way to define sorting logic for objects that don’t have a natural ordering.

The ordering imposed by a `Comparator` is said to be **consistent with equals** if and only if `c.compare(e1, e2) == 0` has the same boolean value as `e1.equals(e2)` for every `e1` and `e2` in the set.

---

#### Important Notes on Usage

1. **Consistency with Equals**:  
   - If the ordering imposed by a `Comparator` on a set of elements is inconsistent with their `equals` method, it may cause strange behavior in sorted data structures.
   - For example, in a `TreeSet` with an explicit comparator `c`, adding two elements `a` and `b` such that `a.equals(b)` but `c.compare(a, b) != 0` will cause both elements to be added, violating the `Set` interface contract.

2. **Serializable Requirement**:  
   - If a `Comparator` is used as the ordering method in serializable data structures (like `TreeSet` or `TreeMap`), it is generally a good idea for the comparator to implement `java.io.Serializable` to ensure the data structure can serialize successfully.

3. **Mathematical Perspective**:  
   - The relation defining the ordering imposed by a comparator `c` on a set of objects `S` is:  
     `{(x, y) such that c.compare(x, y) <= 0}`.
   - The equivalence relation (quotient) is:  
     `{(x, y) such that c.compare(x, y) == 0}`.
   - If the ordering is consistent with equals, this equivalence relation matches the one defined by the `equals` method:  
     `{(x, y) such that x.equals(y)}`.

4. **Handling Nulls**:  
   - Unlike the `Comparable` interface, a `Comparator` may optionally handle `null` arguments while maintaining the requirements of an equivalence relation.

---

#### Real-World Applications of Comparator

The `Comparator` interface is invaluable for imposing a total ordering on objects that may not have a desired natural ordering. For example, a list of `Employee` objects might have a natural ordering based on their `id`. However, real-life applications may require sorting by other criteria, such as:

- **First Name**
- **Date of Birth**
- **Department**
- **Any Other Field**

Using the `Comparator` interface, you can define sorting logic for such custom requirements. It can also be used when:

1. **Sorting Collections/Arrays in Non-Natural Order**:  
   If you need to sort objects in a way that doesn’t align with their natural order.

2. **When Objects Cannot Be Modified**:  
   If you cannot modify the source code of a class to implement the `Comparable` interface.

3. **Group by Sort**:  
   When sorting needs to be applied to multiple fields simultaneously (e.g., first by department, then by salary).

---

### Example of Comparator Usage

```java
import java.util.*;

class Employee {
    int id;
    String firstName;
    String department;

    public Employee(int id, String firstName, String department) {
        this.id = id;
        this.firstName = firstName;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", firstName='" + firstName + "', department='" + department + "'}";
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(3, "Alice", "HR"));
        employees.add(new Employee(1, "Bob", "Engineering"));
        employees.add(new Employee(2, "Charlie", "Marketing"));

        // Sort by First Name
        employees.sort(Comparator.comparing(emp -> emp.firstName));
        System.out.println("Sorted by First Name: " + employees);

        // Sort by Department
        employees.sort(Comparator.comparing(emp -> emp.department));
        System.out.println("Sorted by Department: " + employees);
    }
}
```

---

## Implementation

### Method 1: Write Custom Sort Logic
Requires creating separate sorting logic for each criterion.

### Method 2: Use `Comparator` Interface
Provides built-in methods `compare(Object obj1, Object obj2)` and `equals(Object element)` to define sorting criteria.

#### Example 1: Sorting by Roll Number and Name
```java
// A class to represent a Student
class Student {
    int rollno;
    String name, address;

    public Student(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return rollno + " " + name + " " + address;
    }
}

// Comparator for sorting by roll number
class Sortbyroll implements Comparator<Student> {
    public int compare(Student a, Student b) {
        return a.rollno - b.rollno;
    }
}

// Comparator for sorting by name
class Sortbyname implements Comparator<Student> {
    public int compare(Student a, Student b) {
        return a.name.compareTo(b.name);
    }
}
```

**Main Method**
```java
public static void main(String[] args) {
    ArrayList<Student> ar = new ArrayList<>();
    ar.add(new Student(111, "Mayank", "London"));
    ar.add(new Student(131, "Anshul", "NYC"));
    ar.add(new Student(121, "Solanki", "Jaipur"));
    ar.add(new Student(101, "Aggarwal", "Hong Kong"));

    System.out.println("Unsorted");
    for (Student student : ar) System.out.println(student);

    Collections.sort(ar, new Sortbyroll());
    System.out.println("\nSorted by roll number");
    for (Student student : ar) System.out.println(student);

    Collections.sort(ar, new Sortbyname());
    System.out.println("\nSorted by name");
    for (Student student : ar) System.out.println(student);
}
```

**Output**
```
Unsorted
111 Mayank London
131 Anshul NYC
121 Solanki Jaipur
101 Aggarwal Hong Kong

Sorted by roll number
101 Aggarwal Hong Kong
111 Mayank London
121 Solanki Jaipur
131 Anshul NYC

Sorted by name
101 Aggarwal Hong Kong
131 Anshul NYC
111 Mayank London
121 Solanki Jaipur
```

---

### Example 2: Sort by Multiple Fields
```java
// Class representing a Student
class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{name=" + name + ", age=" + age + '}';
    }

    // Comparator for multi-field sorting
    static class MultiFieldComparator implements Comparator<Student> {
        @Override
        public int compare(Student a, Student b) {
            int nameCompare = a.name.compareTo(b.name);
            return (nameCompare != 0) ? nameCompare : Integer.compare(a.age, b.age);
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ajay", 27));
        students.add(new Student("Sneha", 23));
        students.add(new Student("Simran", 37));
        students.add(new Student("Ajay", 22));
        students.add(new Student("Ajay", 29));
        students.add(new Student("Sneha", 22));

        System.out.println("Before Sorting:");
        students.forEach(System.out::println);

        Collections.sort(students, new MultiFieldComparator());
        System.out.println("\nAfter Sorting:");
        students.forEach(System.out::println);
    }
}
```

**Output**
```
Before Sorting:
Student{name=Ajay, age=27}
Student{name=Sneha, age=23}
Student{name=Simran, age=37}
Student{name=Ajay, age=22}
Student{name=Ajay, age=29}
Student{name=Sneha, age=22}

After Sorting:
Student{name=Ajay, age=22}
Student{name=Ajay, age=27}
Student{name=Ajay, age=29}
Student{name=Simran, age=37}
Student{name=Sneha, age=22}
Student{name=Sneha, age=23}
```

---

## Key Points
- `Comparator` is ideal for sorting objects with flexible criteria.
- The `compare` method controls sort order (ascending or descending).
- Supports multi-field sorting by combining comparisons.
- Enables sorting for objects without modifying their structure.

**Related Concepts**: Java Collections Framework, `Comparable`, `Collections.sort`, `TreeSet`, `TreeMap`.