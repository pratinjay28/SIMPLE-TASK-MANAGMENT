package service;

import model.Task;
import repository.TaskRepository;

import java.util.List;

public class TaskService {
    private List<Task> tasks;
    private TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
        this.tasks = repo.loadTasks();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
        repo.saveTasks(tasks);
    }

    public boolean markTaskCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).setStatus("Done");
            repo.saveTasks(tasks);
            return true;
        }
        return false;
    }

    public boolean editTask(int index, String newDesc, String newPriority, String newDueDate) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.setDescription(newDesc);
            task.setPriority(newPriority);
            task.setDueDate(newDueDate);
            repo.saveTasks(tasks);
            return true;
        }
        return false;
    }

    public boolean deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            repo.saveTasks(tasks);
            return true;
        }
        return false;
    }
} 