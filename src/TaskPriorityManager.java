import java.util.HashMap;
import java.util.Map;
class TaskPriorityManager {
    private Map<Integer, Boolean> taskPriorities = new HashMap<>();

    public void setTaskPriority(int taskId, boolean important) {
        taskPriorities.put(taskId, important);
    }
    
    public boolean isTaskImportant(int taskId) {
        return taskPriorities.getOrDefault(taskId, false);
    }
}
