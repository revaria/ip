package caesar.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a task that occurs within a specific time frame.
 * An Event task includes a description, a start date/time, and an end
 * date/time.
 */
public class Event extends Task {
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    /**
     * Constructs a new Event task with the given description and time range.
     * 
     * @param description The textual description of the event.
     * @param startDate   The date and time when the event begins.
     * @param endDate     The date and time when the event concludes.
     */
    public Event(String description, LocalDateTime startDate, LocalDateTime endDate) {
        super(description);
        setStartDate(startDate);
        setEndDate(endDate);
    }

    /**
     * Sets the start date and time of the event.
     * 
     * @param startDate The new start LocalDateTime.
     */
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    /**
     * Sets the end date and time of the event.
     * 
     * @param endDate The new end LocalDateTime.
     */
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    /**
     * Returns the start date and time formatted as a human-readable string.
     * Format: MMM d yyyy h:mm a (e.g., Oct 15 2026 2:00 PM).
     * 
     * @return A formatted string representation of the start time.
     */
    public String getStartDate() {
        return startDate.format(DateTimeFormatter.ofPattern("MMM d yyyy h:mm a"));
    }

    /**
     * Returns the end date and time formatted as a human-readable string.
     * Format: MMM d yyyy h:mm a (e.g., Oct 15 2026 4:00 PM).
     * 
     * @return A formatted string representation of the end time.
     */
    public String getEndDate() {
        return endDate.format(DateTimeFormatter.ofPattern("MMM d yyyy h:mm a"));
    }

    /**
     * Returns a string representation of the Event for UI display.
     * Includes the "[E]" identifier and the start/end time range.
     * 
     * @return A formatted string representation of the event.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: "
                + getStartDate() + " to: "
                + getEndDate() + ")";
    }

    /**
     * Returns a string formatted for saving the Event to a file.
     * Dates are stored in ISO-8601 format for easy parsing.
     * 
     * @return A machine-readable string representation of the event.
     */
    @Override
    public String toSaveFormat() {
        return "E"
                + " | " + (getIsCompleted() ? "1" : "0")
                + " | " + getDescription()
                + " | " + startDate
                + " | " + endDate;
    }
}
