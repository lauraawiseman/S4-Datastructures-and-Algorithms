package Assignment4;

public class UndoRedoManager<StateType> {
    private DoubleNode<StateType> current;
    
    public void addState(StateType newState){
        DoubleNode<StateType> newNode = new DoubleNode<>(newState);

        if (current != null){
            current.next = null;
            newNode.previous = current;
            current.next = newNode;
        }
        current = newNode;
    }

    public StateType undo(){
        if (current != null && current.previous != null){
            current = current.previous;
            return current.state;
        }
        System.out.println("Nothing to undo.");
        return null;
    }

    public StateType redo(){
        if (current != null && current.next != null){
            current = current.next;
            return current.state;
        }
        System.out.println("Nothing to redo.");
        return null;
    }

    public StateType getCurrentState(){
        return current != null ? current.state : null;
    }
    
}
