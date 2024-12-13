public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        // Adding tasks
        manager.addTask(new Task("Task1", "Description1", false));
        manager.addTask(new PriorityTask("Task2", "Description2", true, "High"));

        // Listing tasks
        manager.listTasks();

        // Updating task status
        manager.updateTaskStatus("Task1", true);

        // Saving tasks to file
        try {
            manager.saveTasksToFile("tasks.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading tasks from file
        try {
            manager.loadTasksFromFile("tasks.dat");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Listing tasks after loading
        manager.listTasks();
    }
}
