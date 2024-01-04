import java.util.Scanner;
import java.util.ArrayList;

class Task {
    private String name;
    private String dueDate;
    private boolean completed;
    private int taskId;
    private String taskName;


    // Constructor
    public Task(String taskName, String dueDate) {
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.completed = false;
    }
    // Getters and setters
    public int getTaskId() {
        return taskId;
    }
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
    public String getTaskName() {
        return name;
    }
    public void setTaskName(String name) {
        this.name = name;
    }
    public String getDueDate() {
        return dueDate;
    }
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();
    private static int nextTaskId = 1;

    private void displayTaskDetails(Task task) {
        System.out.println("Task ID: " + task.getTaskId());
        System.out.println("Task Name: " + task.getTaskName());
        System.out.println("Due Date: " + task.getDueDate());
        System.out.println("Completed: " + task.isCompleted());
        System.out.println();
    }
    public void addTask(Task task) {
        // Assign a unique ID to the task
        task.setTaskId(nextTaskId++);

        // Add the task to the list
        tasks.add(task);

        System.out.println("Task added successfully:");
        displayTaskDetails(task);
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("All Tasks:");
            for (Task task : tasks) {
                displayTaskDetails(task);
            }
        }
    }

    public void updateTaskStatus(int taskId) {
        // Implement logic to update task status
    }

    public void deleteTask(int taskId) {
        // Implement logic to delete a task
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task Status");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Get task details from the user and add a new task
                    break;
                case 2:
                    taskManager.viewTasks();
                    break;
                case 3:
                    // Update task status
                    break;
                case 4:
                    // Delete a task
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}