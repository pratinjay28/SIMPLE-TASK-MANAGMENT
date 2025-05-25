package repository;

import model.Task;
import util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private final String filename;

    public TaskRepository(String filename) {
        this.filename = filename;
    }

    public List<Task> loadTasks() {
        List<String> lines = FileUtil.readLines(filename);
        List<Task> tasks = new ArrayList<>();
        for (String line : lines) {
            Task task = Task.fromFileString(line);
            if (task != null) tasks.add(task);
        }
        return tasks;
    }

    public void saveTasks(List<Task> tasks) {
        List<String> lines = new ArrayList<>();
        for (Task task : tasks) {
            lines.add(task.toFileString());
        }
        FileUtil.writeLines(filename, lines);
    }
}