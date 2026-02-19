package caesar.task;

public class Deadline extends Task {
    private String date;

    public Deadline(String description, String date) {
        super(description);
        setDate(date);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + getDate() + ")";
    }

    @Override
    public String toSaveFormat() {
        return "D"
                + " | " + (getIsCompleted() ? "1" : "0")
                + " | " + getDescription()
                + " | " + getDate();
    }
}
