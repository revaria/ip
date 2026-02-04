import java.util.ArrayList;

public class Parser {
    public static boolean handleCommand(String line, ArrayList<Task> myTasks) {
        // Process user input into two parts
        String[] parts = line.split(" ", 2);
        String command = parts[0].toLowerCase();
        String argument = (parts.length > 1) ? parts[1].trim() : "";

        System.out.println("__________________________________________________________");

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
            case "todo":
                addTodo(myTasks, argument);
                ;
                break;
            case "deadline":
                addDeadline(myTasks, argument);
                break;
            case "event":
                addEvent(myTasks, argument);
                break;
            default:
                System.out.println("I do not understand that command, Brutus. Are you plotting something?");
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

        System.out.println("The Caesar Files are as follows:");
        for (int i = 0; i < myTasks.size(); i++) {
            System.out.println("    " + (i + 1) + ": " + myTasks.get(i).toString());
        }
    }

    public static void handleMark(ArrayList<Task> myTasks, String argument) {
        updateTaskStatus(myTasks, argument, true);
    }

    public static void handleUnmark(ArrayList<Task> myTasks, String argument) {
        updateTaskStatus(myTasks, argument, false);
    }

    private static void updateTaskStatus(ArrayList<Task> myTasks, String argument, boolean isMark) {
        if (argument.isBlank()) {
            System.out.println("Brutus, the Senate cannot update a nameless task!");
            return;
        }

        try {
            int idx = Integer.parseInt(argument) - 1;
            Task t = myTasks.get(idx);

            if (isMark) {
                t.markAsDone();
            } else {
                t.markAsUndone();
            }

            System.out.println(isMark ? "Marking:" : "Unmarking:");
            System.out.println("    " + (idx + 1) + ": " + t);

        } catch (NumberFormatException e) {
            System.out.println("Mark Antony, that's not a valid number!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Mark Antony, that task doesn't exist in our records! Check your list!");
        } catch (Exception e) {
            System.out.println("An unknown error has infiltrated the Senate!");
        }
    }

    public static void addTodo(ArrayList<Task> myTasks, String argument) {
        if (argument.isBlank()) {
            System.out.println("Brutus, the Senate cannot record a nameless task!");
            return;
        }

        try {
            myTasks.add(new Todo(argument));
            addTaskMessage(myTasks);
        } catch (Exception e) {
            System.out.println("An unknown error has infiltrated the Senate!");
        }
    }

    public static void addDeadline(ArrayList<Task> myTasks, String argument) {
        try {
            String[] part = argument.split("/by", 2);
            String description = part[0].trim();
            String date = part[1].trim();

            if (description.isBlank()) {
                System.out.println("Brutus, the Senate cannot record a nameless task!");
                return;
            }
            if (date.isBlank()) {
                System.out.println("Brutus, a deadline without a time is just a wish!");
                return;
            }

            myTasks.add(new Deadline(description, date));
            addTaskMessage(myTasks);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Brutus, use the format: deadline [task] /by [date].");
        } catch (Exception e) {
            System.out.println("An unknown error has infiltrated the Senate!");
        }
    }

    public static void addEvent(ArrayList<Task> myTasks, String argument) {
        try {
            String[] part = argument.split("/from", 2);
            String description = part[0].trim();
            String[] fromToString = part[1].split("/to", 2);
            String startDate = fromToString[0].trim();
            String endDate = fromToString[1].trim();

            if (description.isBlank()) {
                System.out.println("Brutus, the Senate cannot record a nameless task!");
                return;
            }
            if (startDate.isBlank() || endDate.isBlank()) {
                System.out.println("Brutus, an event without a start or an end is just a wish!");
                return;
            }

            myTasks.add(new Event(description, startDate, endDate));
            addTaskMessage(myTasks);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Brutus, use the format: event [task] /from [date] /to [date].");
        } catch (Exception e) {
            System.out.println("An unknown error has infiltrated the Senate!");
        }
    }

    public static void addTaskMessage(ArrayList<Task> myTasks) {
        Task t = myTasks.get(myTasks.size() - 1);
        System.out.println("The Senate acknowledges this task:");
        System.out.println("    " + t);
        System.out.println("Now you have " + myTasks.size() + " task(s) in the records.");
    }

    public static void nextCommandPrompt() {
        System.out.println("What else shall we conquer today?");
        System.out.println("__________________________________________________________");
    }
}
