package Assignment5;

public class Animal {
    public String type;
    public int arrivalOrderCounter;

    public Animal(String type, int arrivalOrderCounter){
        this.type = type.toLowerCase();
        this.arrivalOrderCounter = arrivalOrderCounter;
    }

    @Override
    public String toString(){
        return type + " (# "+ arrivalOrderCounter + ")";
    }
}
