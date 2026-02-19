package caesar.task;

public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String toSaveFormat() {
        return "T"
                + " | " + (getIsCompleted() ? "1" : "0")
                + " | " + getDescription();
    }
}
