public class PriorityTask extends Task {
    private String priority; // low, medium, high

    public PriorityTask(String title, String description, boolean isCompleted, String priority) {
        super(title, description, isCompleted);
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return super.toString() + ", priority='" + priority + '\'';
    }
}
