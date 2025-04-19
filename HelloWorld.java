import java.util.ArrayList;
import java.util.Scanner;

public class HelloWorld {

    static class Task {
        int id;
        String title;
        boolean completed;

        Task(int id, String title) {
            this.id = id;
            this.title = title;
            this.completed = false;
        }

        @Override
        public String toString() {
            return "[" + (completed ? "x" : " ") + "] " + id + ": " + title;
        }
    }

    private static ArrayList<Task> tasks = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to the TODO List App!");

        do {
            System.out.println("\n1. Add Task\n2. View Tasks\n3. Complete Task\n4. Delete Task\n5. Exit");
            System.out.print("Choose an option: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addTask(scanner);
                case 2 -> viewTasks();
                case 3 -> completeTask(scanner);
                case 4 -> deleteTask(scanner);
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        tasks.add(new Task(nextId++, title));
        System.out.println("Task added.");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    private static void completeTask(Scanner scanner) {
        System.out.print("Enter task ID to complete: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Task task : tasks) {
            if (task.id == id) {
                task.completed = true;
                System.out.println("Task marked as complete.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    private static void deleteTask(Scanner scanner) {
        System.out.print("Enter task ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        tasks.removeIf(task -> task.id == id);
        System.out.println("Task deleted.");
    }
}

