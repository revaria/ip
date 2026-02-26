package caesar.task;

/**
 * Represents a generic task in the Caesar application.
 * This is an abstract class that serves as a base for specific task types
 * such as Todo, Deadline, and Event.
 */
public abstract class Task {
    private boolean isCompleted;
    private String description;
    private static int taskCount = 0;

    /**
     * Constructs a new Task with the given description.
     * The task is initialized as not completed.
     * 
     * @param description The textual description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
        taskCount++;
    }

    /**
     * Returns the completion status of the task.
     * 
     * @return true if the task is marked as done, false otherwise.
     */
    public boolean getIsCompleted() {
        return isCompleted;
    }

    /**
     * Returns the description of the task.
     * 
     * @return The task description string.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the total number of Task instances created.
     * 
     * @return The current task count.
     */
    public static int getTaskCount() {
        return taskCount;
    }

    /**
     * Marks the task as completed.
     */
    public void markAsDone() {
        this.isCompleted = true;
    }

    /**
     * Marks the task as incomplete.
     */
    public void markAsUndone() {
        this.isCompleted = false;
    }

    /**
     * Updates the description of the task.
     * 
     * @param description The new description to set.
     */
    public void updateDescription(String description) {
        this.description = description;
    }

    /**
     * Returns a string representation of the task, including its completion status.
     * 
     * @return A formatted string suitable for display in the UI.
     */
    public String toString() {
        String status = isCompleted ? "[X] " : "[ ] ";
        return status + description;
    }

    /**
     * Returns a string formatted specifically for saving the task to a file.
     * This must be implemented by all subclasses.
     * 
     * @return A machine-readable string representation of the task.
     */
    public abstract String toSaveFormat();
}
