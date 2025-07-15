package Assignment5;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n--- Enqueuing Animals ---");
        AnimalShelterQueue shelter = new AnimalShelterQueue(6);
        shelter.enqueue("Dog");
        shelter.enqueue("Cat");
        shelter.enqueue("Dog");
        shelter.enqueue("Cat");
        shelter.enqueue("Dog");
        shelter.enqueue("Cat");
       
        System.out.println("\n--- Current Peek ---");
        System.out.println("Peek (Oldest Animal by arrival): "+ shelter.peek());
        System.out.println("Peek (Oldest Dog by Arrival): "+ shelter.peekDog());
        System.out.println("Peek (Oldest Cat by Arrival): "+ shelter.peekCat());

        System.out.println("\n--- Dequeue Dog ---");
        System.out.println("Dequeued dog: "+ shelter.dequeueDog());
        System.out.println("Peek (Oldest Dog by Arrival):" + shelter.peekDog());

        System.out.println("\n--- Dequeue Cat ---");
        System.out.println("Dequeued Cat: "+ shelter.dequeueCat());
        System.out.println("Peek (Oldest Cat by Arrival):" + shelter.peekCat());

        // Dequeue all remaining animals
        System.out.println("\n--- Dequeue Any ---");
        while (!shelter.isEmpty()){
            System.out.println("Dequeue Any: " + shelter.dequeue());

        }

        System.out.println("\n--- Current Peek ---");
        System.out.println("Peek (Oldest Animal by arrival): "+ shelter.peek());
        System.out.println("Peek (Oldest Dog by Arrival): "+ shelter.peekDog());
        System.out.println("Peek (Oldest Cat by Arrival): "+ shelter.peekCat());
    }
}
