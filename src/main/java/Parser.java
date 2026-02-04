import java.util.ArrayList;

public class Parser {
    public static boolean handleCommand(String line, ArrayList<Task> myTasks) {
        // Process user input into two parts
        String[] parts = line.split(" ", 2);
        String command = parts[0].toLowerCase();
        String argument = (parts.length > 1) ? parts[1].trim() : "";

        switch (command) {
            case "bye":
                handleBye();
                return false;
            case "list":
                handleList(myTasks);
                break;
            case "mark":
                handleMark(myTasks, argument);
                break;
            case "unmark":
                handleUnmark(myTasks, argument);
                break;
            default:
                handleAddTask(line, myTasks);
        }
        nextCommandPrompt();
        return true;
    }

    public static void handleBye() {
        System.out.println("Goodbye Brutus, the stars speak of our inevitable reunion.");
    }

    public static void handleList(ArrayList<Task> myTasks) {
        if (myTasks.isEmpty()) {
            System.out.println("The Caesar Files are empty!");
            return;
        }
        for (int i = 0; i < myTasks.size(); i++) {
            System.out.println((i + 1) + ": " + myTasks.get(i).toString());
        }
    }

    public static void handleMark(ArrayList<Task> myTasks, String argument) {
        updateTaskStatus(myTasks, argument, true);
    }

    public static void handleUnmark(ArrayList<Task> myTasks, String argument) {
        updateTaskStatus(myTasks, argument, false);
    }

    private static void updateTaskStatus(ArrayList<Task> myTasks, String argument, boolean isMark) {
        try {
            int idx = Integer.parseInt(argument) - 1;
            Task t = myTasks.get(idx);
            if (isMark) {
                t.markAsDone();
            } else {
                t.markAsUndone();
            }
            System.out.println(isMark ? "Marking:" : "Unmarking:");
            System.out.println((idx + 1) + ": " + t);
        } catch (NumberFormatException e) {
            System.out.println("Mark Antony, that's not a valid number!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Mark Antony, that task doesn't exist in our records! Check your list!");
        } catch (Exception e) {
            System.out.println("An unknown error has infiltrated the Senate!");
        }
    }

    public static void handleAddTask(String line, ArrayList<Task> myTasks) {
        myTasks.add(new Task(line));
        System.out.println("added: " + line);
    }

    public static void nextCommandPrompt() {
        System.out.println("What else shall we conquer today?");
        System.out.println("__________________________________________________________");
    }
}
