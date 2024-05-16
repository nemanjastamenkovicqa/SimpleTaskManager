import java.util.Collections;

class TaskManagerFeatures {

    public static void sortTasksByPriority(TaskManager taskManager) {
        Collections.sort(taskManager.getTasks(), (task1, task2) -> {
            boolean priority1 = task1.isImportant();
            boolean priority2 = task2.isImportant();
            // Reverse order to have important tasks first
            return Boolean.compare(priority2, priority1);
        });
        System.out.println("Tasks sorted by priority.");
    }

    public static void markTaskAsImportant(TaskManager taskManager, int taskId) {
        Task taskToMark = taskManager.findTaskById(taskId);

        if (taskToMark != null) {
            taskToMark.setImportant(true);
            System.out.println("Task marked as important:");
            displayTaskDetails(taskToMark);
        } else {
            System.out.println("Task not found with ID: " + taskId);
        }
    }

    public static void displayTaskDetails(Task task) {
        System.out.println("Task ID: " + task.getTaskId());
        System.out.println("Task Name: " + task.getTaskName());
        System.out.println("Due Date: " + task.getDueDate());
        System.out.println("Completed: " + task.isCompleted());
        System.out.println("Priority Level: " + task.getPriorityLevel().getPriorityName());
        System.out.println("Importance: " + task.isImportant());
        System.out.println();
    }
}
