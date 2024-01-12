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
    private int nextTaskId = 1;


    private void displayTaskDetails(Task task) {
        System.out.println("Task ID: " + task.getTaskId());
        System.out.println("Task Name: " + task.getTaskName());
        System.out.println("Due Date: " + task.getDueDate());
        System.out.println("Completed: " + task.isCompleted());
        System.out.println();
    }
    public void sortTasksByDueDate() {
        TaskSorter.sortTasksByDueDate(tasks);
    }
    public void getTaskDetailsAndAddTask(Scanner scanner) {
        System.out.print("Enter Task Name: ");
        String taskName = scanner.nextLine();

        System.out.print("Enter Due Date: ");
        String dueDate = scanner.nextLine();

        Task newTask = new Task(taskName, dueDate);
        addTask(newTask);
    }
    public ArrayList<Task> getTasks() {
        return tasks;
    }
    public void updateNextTaskId() {
        if (!tasks.isEmpty()) {
            int maxId = tasks.stream().mapToInt(Task::getTaskId).max().orElse(0);
            nextTaskId = maxId + 1;
        }
    }
    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
        updateNextTaskId(); // Call this method to ensure the nextTaskId is updated based on loaded tasks
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

    public void updateTaskStatus(int taskId, boolean completed) {
        Task taskToUpdate = findTaskById(taskId);

        if (taskToUpdate != null) {
            taskToUpdate.setCompleted(completed);
            System.out.println("Task status updated successfully:");
            displayTaskDetails(taskToUpdate);
        } else {
            System.out.println("Task not found with ID: " + taskId);
        }
    }

    // Add this helper method to your TaskManager class
    private Task findTaskById(int taskId) {
        for (Task task : tasks) {
            if (task.getTaskId() == taskId) {
                return task;
            }
        }
        return null;
    }

    public void deleteTask(int taskId) {
        Task taskToDelete = findTaskById(taskId);

        if (taskToDelete != null) {
            tasks.remove(taskToDelete);
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task not found with ID: " + taskId);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        // Load tasks from the file when the program starts
        taskManager.setTasks(TaskFileHandler.loadTasks());
        taskManager.updateNextTaskId(); // Update nextTaskId based on loaded tasks

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
                    taskManager.getTaskDetailsAndAddTask(scanner);
                    break;
                case 2:
                    taskManager.viewTasks();
                    break;
                case 3:
                    taskManager.updateTaskStatus(scanner.nextInt(), scanner.nextBoolean());
                    break;
                case 4:
                    System.out.print("Enter Task ID to delete: ");
                    int taskIdToDelete = scanner.nextInt();
                    taskManager.deleteTask(taskIdToDelete);
                    break;
                case 5:
                    taskManager.sortTasksByDueDate(); // Use the sorting method from TaskManager
                    break;
                case 6:
                    TaskFileHandler.saveTasks(taskManager.getTasks());
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}