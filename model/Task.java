package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Task {
    private String description;
    private String priority;  // High, Medium, Low
    private LocalDate dueDate;  // optional
    private String status;  // To Do, In Progress, Done

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Task(String description, String priority, String dueDateStr, String status) {
        this.description = description;
        this.priority = priority;
        this.status = status;
        if (dueDateStr == null || dueDateStr.isBlank()) {
            this.dueDate = null;
        } else {
            try {
                this.dueDate = LocalDate.parse(dueDateStr, formatter);
            } catch (DateTimeParseException e) {
                this.dueDate = null;
            }
        }
    }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(String dueDateStr) {
        if (dueDateStr == null || dueDateStr.isBlank()) {
            this.dueDate = null;
        } else {
            try {
                this.dueDate = LocalDate.parse(dueDateStr, formatter);
            } catch (DateTimeParseException e) {
                this.dueDate = null;
            }
        }
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Format task details for display
    public String display() {
        String dueDateStr = (dueDate == null) ? "N/A" : dueDate.format(formatter);
        return String.format("Description: %s | Priority: %s | Due Date: %s | Status: %s",
                description, priority, dueDateStr, status);
    }

    // Format for saving to file: description|priority|dueDate|status
    public String toFileString() {
        String dueDateStr = (dueDate == null) ? "" : dueDate.format(formatter);
        return description + "|" + priority + "|" + dueDateStr + "|" + status;
    }

    // Static method to parse a Task from a line in file
    public static Task fromFileString(String line) {
        String[] parts = line.split("\\|");
        if (parts.length != 4) return null;
        return new Task(parts[0], parts[1], parts[2], parts[3]);
    }
}
