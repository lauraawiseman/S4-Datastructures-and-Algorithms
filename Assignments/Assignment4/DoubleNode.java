package Assignment4;

public class DoubleNode<StateType> {
    public StateType state;
    public DoubleNode<StateType> next;
    public DoubleNode<StateType> previous;

    public DoubleNode(StateType state){
        this.state = state;
    }
}
