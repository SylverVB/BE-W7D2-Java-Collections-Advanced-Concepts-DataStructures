// Exercise
// Use the Comparator interface to modify to sort by name in reverse order.

package ComparableComparator.Exercise;

// Java Program to Demonstrate Working of
// Comparator Interface Via More than One Field
// Modified to sort by name in reverse order

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

// or
// import java.util.*;

// Class representing a Student
class NewStudent {

    // Attributes of student
    String Name;
    int Age;

    // Parameterized constructor
    public NewStudent(String Name, Integer Age) {
        this.Name = Name;
        this.Age = Age;
    }

    // Getter and setter methods
    public String getName() { return Name; }

    public void setName(String Name) { this.Name = Name; }

    public Integer getAge() { return Age; }

    public void setAge(Integer Age) { this.Age = Age; }

    // Method to return student details as a string
    @Override 
    public String toString() {
        return "Student{" + "Name=" + Name + ", Age=" + Age + '}';
    }

    // Comparator to sort by Name in reverse order and Age in ascending order
    static class StudentSortingComparator implements Comparator<NewStudent> {

        // Method to compare students
        @Override
        public int compare(NewStudent student1, NewStudent student2) {
            // 1st level: Compare by Name in reverse order
            int NameCompare = student2.getName().compareTo(student1.getName());

            // 2nd level: Compare by Age if names are equal
            if (NameCompare == 0) {
                return Integer.compare(student1.getAge(), student2.getAge());
            }
            return NameCompare;
        }
    }
}

// Main class containing the main method
public class Main {
    public static void main(String[] args) {
        // Create an empty ArrayList to store Student objects
        List<NewStudent> al = new ArrayList<>();

        // Create student objects using constructor initialization
        NewStudent obj1 = new NewStudent("Ajay", 27);
        NewStudent obj2 = new NewStudent("Sneha", 23);
        NewStudent obj3 = new NewStudent("Simran", 37);
        NewStudent obj4 = new NewStudent("Ajay", 22);
        NewStudent obj5 = new NewStudent("Ajay", 29);
        NewStudent obj6 = new NewStudent("Sneha", 22);

        // Adding student objects to ArrayList using add() method
        al.add(obj1);
        al.add(obj2);
        al.add(obj3);
        al.add(obj4);
        al.add(obj5);
        al.add(obj6);

        // Iterating using Iterator before Sorting ArrayList
        Iterator<NewStudent> studentIterator = al.iterator();

        // Display message
        System.out.println("Before Sorting:\n");

        // Iterating using next() method
        while (studentIterator.hasNext()) {
            System.out.println(studentIterator.next());
        }

        // Sorting using sort method of Collections class
        Collections.sort(al, new NewStudent.StudentSortingComparator());

        // Display message after sorting
        System.out.println("\n\nAfter Sorting:\n");

        // Iterating using enhanced for-loop after Sorting ArrayList
        for (NewStudent student : al) {
            System.out.println(student);
        }
    }
}