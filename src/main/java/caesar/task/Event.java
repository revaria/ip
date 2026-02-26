package caesar.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Event(String description, LocalDateTime startDate, LocalDateTime endDate) {
        super(description);
        setStartDate(startDate);
        setEndDate(endDate);
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate.format(DateTimeFormatter.ofPattern("MMM d yyyy h:mm a"));
    }

    public String getEndDate() {
        return endDate.format(DateTimeFormatter.ofPattern("MMM d yyyy h:mm a"));
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: "
                + getStartDate() + " to: "
                + getEndDate() + ")";
    }

    @Override
    public String toSaveFormat() {
        return "E"
                + " | " + (getIsCompleted() ? "1" : "0")
                + " | " + getDescription()
                + " | " + startDate
                + " | " + endDate;
    }
}
