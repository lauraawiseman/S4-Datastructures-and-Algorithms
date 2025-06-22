package Assignment4;

public class Main {
    public static void main(String[] args) {
        UndoRedoManager<String> manager = new UndoRedoManager<>();

        manager.addState("Step 1");
        manager.addState("Step 2");
        manager.addState("Step 3");

        System.out.println("Current " + manager.getCurrentState()); // Step 3

        manager.undo();
        System.out.println("After undo: " + manager.getCurrentState()); // Step 2

        manager.redo();
        System.out.println("After redo: " + manager.getCurrentState()); // Step 3

        manager.addState("Step 4"); // Should delete redo path

        manager.redo(); // Should say "nothing to redo"


    }
}
