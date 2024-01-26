import java.io.*;
import java.util.ArrayList;

public class TaskFileHandler {
    private static final String FILE_NAME = "tasks.txt";
    private static final String CSV_FILE_NAME = "tasks.csv";

    public static void saveTasks(ArrayList<Task> tasks) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(tasks);
            System.out.println("Tasks saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public static ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList) {
                tasks = (ArrayList<Task>) obj;
                System.out.println("Tasks loaded successfully.");
            }
        } catch (FileNotFoundException e) {
            // File does not exist, it's okay, just return an empty list
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
        return tasks;
    }

    public static void exportTasksToCSV(ArrayList<Task> tasks) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE_NAME))) {
            // Write header
            writer.println("Task ID,Task Name,Due Date,Completed,Priority Level,Important");

            // Write tasks
            for (Task task : tasks) {
                writer.println(task.getTaskId() + "," +
                        task.getTaskName() + "," +
                        task.getDueDate() + "," +
                        task.isCompleted() + "," +
                        task.getPriorityLevel().getName() + "," +
                        task.isImportant());
            }

            System.out.println("Tasks exported to CSV successfully: " + CSV_FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error exporting tasks to CSV: " + e.getMessage());
        }
    }
}
