class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Animal> animals = new DoublyLinkedList<>(Animal.class);

        // Add animals to the list
        animals.add(new Animal("Cat"));
        animals.add(new Animal("Dog"));
        animals.add(new Animal("Rabbit"));

        // Retrieve and print the size of the list
        System.out.println("Size: " + animals.size());

        // Retrieve and print elements
        System.out.println("First animal: " + animals.element());
        System.out.println("Second animal: " + animals.element(1));

        // Convert to array and print elements
        Animal[] animalArray = animals.toArray();
        for (Animal animal : animalArray) {
            System.out.println("Animal: " + animal);
        }

        // Set a new value at index 1 and print the updated element
        animals.set(1, new Animal("Elephant"));
        System.out.println("Updated second animal: " + animals.element(1));

        // Remove the head element and print the new head
        animals.remove();
        System.out.println("New first animal: " + animals.element());

        // Clear the list and print its size
        animals.clear();
        System.out.println("Size after clear: " + animals.size());
    }
}
