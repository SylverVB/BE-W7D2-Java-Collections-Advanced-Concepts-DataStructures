package ArrayListLinkedLIst.LinkedListExample;

// Import the LinkedList class
import java.util.LinkedList;

class SuperHeroesList {

    public static void main(String[] args) {
        System.out.println("Creating a list of Superheroes...");

        String shazam = "Shazam";

        // Create a new LinkedList
        LinkedList<String> superHeroes = new LinkedList<>();
        
        // Add objects to the list
        superHeroes.add("Superman");
        superHeroes.add("The Incredible Hulk");
        superHeroes.add(1, "Spider Woman");
        superHeroes.add(shazam);
        superHeroes.addLast("Bugs Bunny");
        superHeroes.addFirst("Flash");
        
        System.out.println("Initial list of Superheroes: " + superHeroes);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Get items from the list
        System.out.println("First superhero in the list: " + superHeroes.getFirst());
        System.out.println("Last superhero in the list: " + superHeroes.getLast());
        System.out.println("Superhero at index 3: " + superHeroes.get(3));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Change an element in the list
        superHeroes.set(5, "Bugs Bunny"); // Correct capitalization of "Bugs Bunny"
        System.out.println("List after changing the last superhero to 'Bugs Bunny': " + superHeroes);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Removing objects from the list
        superHeroes.remove("Bugs Bunny"); // Remove by object
        superHeroes.remove(shazam); // Remove using the variable
        superHeroes.remove(1); // Remove by index
        System.out.println("List after removing some superheroes: " + superHeroes);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Iterating through the list
        System.out.println("Iterating through the remaining superheroes:");
        for (String superHero : superHeroes) {
            System.out.println(superHero);
        }

        // Empty the list
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Size of the list before clearing: " + superHeroes.size());
        superHeroes.clear();
        System.out.println("Size of the list after clearing: " + superHeroes.size());
    }
}