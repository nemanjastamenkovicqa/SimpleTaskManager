import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TaskSorter {

    public static void sortTasksByDueDate(ArrayList<Task> tasks) {
        if (!tasks.isEmpty()) {
            Collections.sort(tasks, Comparator.comparing(Task::getDueDate));
            System.out.println("Tasks sorted by due date.");
        } else {
            System.out.println("No tasks available to sort.");
        }
    }

    public static void sortTasksByPriority(ArrayList<Task> tasks) {
        if (!tasks.isEmpty()) {
            Collections.sort(tasks, Comparator.comparing(Task::getPriority));
            System.out.println("Tasks sorted by priority.");
        } else {
            System.out.println("No tasks available to sort.");
        }
    }

    // You can add additional sorting methods based on different criteria if needed

    // New function to upgrade TaskSorter
    public static void sortTasksByCompletion(ArrayList<Task> tasks) {
        if (!tasks.isEmpty()) {
            Collections.sort(tasks, Comparator.comparing(Task::isCompleted));
            System.out.println("Tasks sorted by completion status.");
        } else {
            System.out.println("No tasks available to sort.");
        }
    }
}
