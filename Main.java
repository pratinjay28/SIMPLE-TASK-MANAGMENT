import model.Task;
import repository.TaskRepository;
import service.TaskService;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DATA_FILE = "tasks.txt";

    public static void main(String[] args) {
        TaskRepository repo = new TaskRepository(DATA_FILE);
        TaskService service = new TaskService(repo);

        boolean running = true;
        while (running) {
            clearScreen();
            showMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> addTask(service);
                case 2 -> viewTasks(service);
                case 3 -> markTaskCompleted(service);
                case 4 -> editTask(service);
                case 5 -> deleteTask(service);
                case 6 -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice! Press Enter to continue...");
            }
            if (running) pause();
        }
    }

    private static void showMenu() {
        System.out.println("=== SIMPLE TASK MANAGER ===");
        System.out.println("1. Add New Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task as Completed");
        System.out.println("4. Edit Task");
        System.out.println("5. Delete Task");
        System.out.println("6. Exit");
    }

    private static void addTask(TaskService service) {
        System.out.println("--- Add New Task ---");
        System.out.print("Enter task description: ");
        String desc = scanner.nextLine().trim();

        String priority = "";
        do {
            System.out.print("Enter priority (High/Medium/Low): ");
            priority = scanner.nextLine().trim();
        } while (!priority.equalsIgnoreCase("High") &&
                !priority.equalsIgnoreCase("Medium") &&
                !priority.equalsIgnoreCase("Low"));

        System.out.print("Enter due date (YYYY-MM-DD, optional): ");
        String dueDate = scanner.nextLine().trim();

        Task task = new Task(desc, capitalize(priority), dueDate, "To Do");
        service.addTask(task);
        System.out.println("Task added.");
    }

    private static void viewTasks(TaskService service) {
        System.out.println("--- Tasks ---");
        List<Task> tasks = service.getTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            System.out.printf("[%d] %s%n", i, t.display());
        }
    }

    private static void markTaskCompleted(TaskService service) {
        System.out.println("--- Mark Task as Completed ---");
        int index = readInt("Enter task index: ");
        if (service.markTaskCompleted(index)) {
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Invalid task index!");
        }
    }

    private static void editTask(TaskService service) {
        System.out.println("--- Edit Task ---");
        int index = readInt("Enter task index: ");
        List<Task> tasks = service.getTasks();
        if (index < 0 || index >= tasks.size()) {
            System.out.println("Invalid task index!");
            return;
        }
        Task task = tasks.get(index);
        System.out.println("Current: " + task.display());

        System.out.print("New description (leave blank to keep): ");
        String desc = scanner.nextLine().trim();
        if (desc.isEmpty()) desc = task.getDescription();

        String priority = "";
        do {
            System.out.print("New priority (High/Medium/Low, leave blank to keep): ");
            priority = scanner.nextLine().trim();
            if (priority.isEmpty()) {
                priority = task.getPriority();
                break;
            }
        } while (!priority.equalsIgnoreCase("High") &&
                !priority.equalsIgnoreCase("Medium") &&
                !priority.equalsIgnoreCase("Low"));

        System.out.print("New due date (YYYY-MM-DD, leave blank to keep): ");
        String dueDate = scanner.nextLine().trim();
        if (dueDate.isEmpty() && task.getDueDate() != null)
            dueDate = task.getDueDate().toString();

        if (service.editTask(index, desc, capitalize(priority), dueDate)) {
            System.out.println("Task updated.");
        } else {
            System.out.println("Failed to update task.");
        }
    }

    private static void deleteTask(TaskService service) {
        System.out.println("--- Delete Task ---");
        int index = readInt("Enter task index: ");
        if (service.deleteTask(index)) {
            System.out.println("Task deleted.");
        } else {
            System.out.println("Invalid task index!");
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine();
            try {
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, please try again.");
            }
        }
    }

    private static String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
    }

    private static void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private static void clearScreen() {
        // Clear console screen - works on many terminals (may not work in some IDE consoles)
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}