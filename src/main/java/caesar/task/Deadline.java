package caesar.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private LocalDateTime date;

    public Deadline(String description, LocalDateTime date) {
        super(description);
        setDate(date);
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDate() {
        return date.format(DateTimeFormatter.ofPattern("MMM d yyyy h:mm a"));
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
                + " | " + date;
    }
}
