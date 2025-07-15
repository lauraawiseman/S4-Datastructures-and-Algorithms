package Assignment5;

public class AnimalShelterQueue {
    private Animal[] queue;
    private int frontOfQueue;
    private int rearOfQueue;
    private int size;
    private int arrivalOrderCounter;

    // Create Array
    public AnimalShelterQueue(int size){
        this.queue = new Animal[size];
        this.frontOfQueue = 0;
        this.rearOfQueue = -1;
        this.size = 0;
        this.arrivalOrderCounter = 0;
        System.out.println("The shelter queue has been successfully created with size of: "+ size);
    }

    // isFull
    public boolean isFull(){
        if (rearOfQueue == queue.length - 1){
            System.out.println("The shelter queue is full.");
            return true;
            
        } else{
            return false;
        }
    }

    // isEmpty
    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }

    // Enqueue
    public void enqueue(String type){
        if (isFull()){
            System.out.println("The shelter queue is full.");

        } else if (isEmpty()){
            frontOfQueue = 0;
            rearOfQueue++;
            queue[rearOfQueue] = new Animal(type, arrivalOrderCounter);
            arrivalOrderCounter++;
            size++;

        } else {
            rearOfQueue++;
            queue[rearOfQueue] = new Animal(type, arrivalOrderCounter);
            arrivalOrderCounter++;
            size++;
        }
    }

    // Peek any
    public Animal peek(){
        if (!isEmpty()){
            return queue[frontOfQueue];
        } else {
          System.out.println("No animals in the shelter queue.");
          return null;
        }
    }

    // Peek Dog
    public Animal peekDog(){
        for (int i = frontOfQueue; i <= rearOfQueue; i++){
            if (queue[i].type.equalsIgnoreCase("dog")){
                return queue[i];
            }
        }
        System.out.println("No dogs in the shelter queue.");
        return null;
    }

     // Peek Cat
    public Animal peekCat(){
        for (int i = frontOfQueue; i <= rearOfQueue; i++){
            if (queue[i].type.equalsIgnoreCase("cat")){
                return queue[i];
            }
        }
        System.out.println("No cats in the queue.");
        return null;
    }


    // Dequeue/Poll
    public Animal dequeue(){
        if (isEmpty()){
            System.out.println("No animals in the shelter queue.");
            return null;
        } 

        Animal result = queue[frontOfQueue];
        frontOfQueue++;
        size--;

        if (frontOfQueue > rearOfQueue){
            frontOfQueue = 0;
            rearOfQueue = -1;
        }
        
        return result;
    }

    public Animal dequeueDog(){
        return dequeueType("dog");
    }

    public Animal dequeueCat(){
        return dequeueType("cat");
    }

    public Animal dequeueType(String type){
        if (isEmpty()){
            System.out.println("No animals in the shelter queue.");
            return null;
        }

        for (int i = frontOfQueue; i <= rearOfQueue; i++){
            if (queue[i].type.equalsIgnoreCase(type)){
                Animal removed = queue[i];

                // Shift animals after i to the left
                for (int j = i; j < rearOfQueue; j++){
                    queue[j] = queue[j + 1];
                }
                queue[rearOfQueue] = null;
                rearOfQueue--;
                size--;

                if (size == 0){
                    frontOfQueue = 0;
                    rearOfQueue = -1;
                }
                return removed;
            }
        }
        System.out.println("No " + type + " found in the shelter queue.");
        return null;
    }

    // Delete
    public void deleteQueue(){
        queue = null;
        System.out.println("The shelter queue has been successfully deleted.");
    };
}