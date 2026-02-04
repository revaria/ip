public class Task {
    private boolean isCompleted;
    private String description;
    private static int taskCount = 0;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
        taskCount++;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public static int getTaskCount() {
        return taskCount;
    }

    public void markAsDone() {
        this.isCompleted = true;
    }

    public void markAsUndone() {
        this.isCompleted = false;
    }

    public void updateDescription(String description) {
        this.description = description;
    }

    public String toString() {
        String status = isCompleted ? "[X] " : "[ ] ";
        return status + description;
    }
}
