package Assignment4;

public class UndoRedoManager<StateType> {
    private DoubleNode<StateType> current;
    
    // Adds a new state and clears any redo history
    public void addState(StateType newState){
        DoubleNode<StateType> newNode = new DoubleNode<>(newState);

        if (current != null){
            // Disconnects redo nodes
            current.next = null;
            newNode.previous = current;
            current.next = newNode;
        }
        current = newNode;
    }

    // Moves one step back if possible
    public StateType undo(){
        if (current != null && current.previous != null){
            current = current.previous;
            return current.state;
        }
        System.out.println("Nothing to undo.");
        return null;
    }

    // Moves one step forward if possible
    public StateType redo(){
        if (current != null && current.next != null){
            current = current.next;
            return current.state;
        }
        System.out.println("Nothing to redo.");
        return null;
    }

    // Returns the current state
    public StateType getCurrentState(){
        return current != null ? current.state : null;
    }
    
}
