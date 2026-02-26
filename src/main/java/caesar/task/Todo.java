package caesar.task;

/**
 * Represents a basic task without any specific date or time constraints.
 * A Todo task is identified by the "[T]" prefix in the user interface.
 */
public class Todo extends Task {

    /**
     * Constructs a new Todo task with the specified description.
     * 
     * @param description The textual description of the task.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Returns a string representation of the Todo task for UI display.
     * Includes the "[T]" type identifier followed by the base task status.
     * 
     * @return A formatted string representation of the Todo task.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Returns a string formatted for saving the Todo task to a file.
     * The format used is "T | status | description".
     * 
     * @return A machine-readable string representation of the Todo task.
     */
    @Override
    public String toSaveFormat() {
        return "T"
                + " | " + (getIsCompleted() ? "1" : "0")
                + " | " + getDescription();
    }
}
