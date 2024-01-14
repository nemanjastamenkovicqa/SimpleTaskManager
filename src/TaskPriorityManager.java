import java.util.HashMap;
import java.util.Map;
class TaskPriorityManager {
    private Map<Integer, Boolean> taskPriorities = new HashMap<>();

    // Method to set task priority
    public void setTaskPriority(int taskId, boolean important) {
        taskPriorities.put(taskId, important);
    }

    // Method to check if a task is important
    public boolean isTaskImportant(int taskId) {
        return taskPriorities.getOrDefault(taskId, false);
    }
}