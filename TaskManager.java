import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task added: " + task.getTitle());
    }

    public void removeTask(String title) {
        tasks.removeIf(task -> task.getTitle().equalsIgnoreCase(title));
        System.out.println("Task removed: " + title);
    }

    public void updateTaskStatus(String title, boolean isCompleted) {
        for (Task task : tasks) {
            if (task.getTitle().equalsIgnoreCase(title)) {
                task.setCompleted(isCompleted);
                System.out.println("Task updated: " + title);
                return;
            }
        }
        System.out.println("Task not found: " + title);
    }

    public void saveTasksToFile(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(tasks);
            System.out.println("Tasks saved to file: " + fileName);
        }
    }

    @SuppressWarnings("unchecked")
    public void loadTasksFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            tasks = (List<Task>) ois.readObject();
            System.out.println("Tasks loaded from file: " + fileName);
        }
    }

    public void listTasks() {
        System.out.println("Tasks:");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
