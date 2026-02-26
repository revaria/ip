package caesar.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a task that must be completed by a specific deadline.
 * A Deadline task includes a description and a single target date and time.
 */
public class Deadline extends Task {
    private LocalDateTime date;

    /**
     * Constructs a new Deadline task with the specified description and due date.
     * 
     * @param description The textual description of the task.
     * @param date        The LocalDateTime by which the task must be completed.
     */
    public Deadline(String description, LocalDateTime date) {
        super(description);
        setDate(date);
    }

    /**
     * Updates the deadline date and time for this task.
     * 
     * @param date The new target LocalDateTime.
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Returns the deadline date and time formatted as a human-readable string.
     * Format: MMM d yyyy h:mm a (e.g., Dec 2 2026 6:00 PM).
     * 
     * @return A formatted string representation of the deadline.
     */
    public String getDate() {
        return date.format(DateTimeFormatter.ofPattern("MMM d yyyy h:mm a"));
    }

    /**
     * Returns a string representation of the Deadline for UI display.
     * Includes the "[D]" identifier and the "by" date information.
     * 
     * @return A formatted string representation of the deadline task.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + getDate() + ")";
    }

    /**
     * Returns a string formatted for saving the Deadline to a file.
     * The date is stored in ISO-8601 format to ensure reliable parsing.
     * 
     * @return A machine-readable string representation of the deadline.
     */
    @Override
    public String toSaveFormat() {
        return "D"
                + " | " + (getIsCompleted() ? "1" : "0")
                + " | " + getDescription()
                + " | " + date;
    }
}
