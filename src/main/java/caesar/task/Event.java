package caesar.task;

public class Event extends Task {
    private String startDate;
    private String endDate;

    public Event(String description, String startDate, String endDate) {
        super(description);
        setStartDate(startDate);
        setEndDate(endDate);
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
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
                + " | " + getStartDate()
                + " | " + getEndDate();
    }
}
