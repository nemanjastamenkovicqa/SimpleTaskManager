import java.util.Scanner;
import java.util.ArrayList;

class Task {
    private String name;
    private String dueDate;
    private boolean completed;

    // Constructor, getters, and setters go here
}

class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        // Implement logic to add a task
    }

    public void viewTasks() {
        // Implement logic to display all tasks
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
                    // View all tasks
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