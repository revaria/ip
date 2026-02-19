package caesar.parser;

import caesar.task.*;
import caesar.exception.*;
import java.util.ArrayList;

public class Parser {
    public static boolean handleCommand(String line,
            ArrayList<Task> myTasks) throws CaesarException {
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
                break;
            case "deadline":
                addDeadline(myTasks, argument);
                break;
            case "event":
                addEvent(myTasks, argument);
                break;
            case "delete":
                deleteTask(myTasks, argument);
                break;
            default:
                throw new CaesarException(
                        "I do not understand that command, Brutus. Are you plotting something?");
        }

        nextCommandPrompt();
        return true;
    }

    private static void handleBye() {
        System.out.println("Goodbye Brutus, the stars speak of our inevitable reunion.");
    }

    private static void handleList(ArrayList<Task> myTasks) {
        if (myTasks.isEmpty()) {
            System.out.println("The Caesar Files are empty!");
            return;
        }

        System.out.println("The Caesar Files are as follows:");
        for (int i = 0; i < myTasks.size(); i++) {
            System.out.println("    " + (i + 1) + ": " + myTasks.get(i).toString());
        }
    }

    private static void handleMark(
            ArrayList<Task> myTasks,
            String argument) throws CaesarException {
        updateTaskStatus(myTasks, argument, true);
    }

    private static void handleUnmark(
            ArrayList<Task> myTasks,
            String argument) throws CaesarException {
        updateTaskStatus(myTasks, argument, false);
    }

    private static void updateTaskStatus(
            ArrayList<Task> myTasks,
            String argument,
            boolean isMark) throws CaesarException {
        if (argument.isBlank()) {
            throw new CaesarException("Brutus, the Senate cannot update a nameless task!");
        }

        int idx;
        try {
            idx = Integer.parseInt(argument) - 1;
        } catch (NumberFormatException e) {
            throw new CaesarException("Mark Antony, that's not a valid number!");
        }

        if (idx < 0 || idx >= myTasks.size()) {
            throw new CaesarException("Mark Antony, that task doesn't exist in our records! Check your list!");
        }

        Task t = myTasks.get(idx);

        if (isMark) {
            t.markAsDone();
        } else {
            t.markAsUndone();
        }

        System.out.println(isMark ? "Marking:" : "Unmarking:");
        System.out.println(" " + (idx + 1) + ": " + t);
    }

    private static void addTodo(
            ArrayList<Task> myTasks,
            String argument) throws CaesarException {
        if (argument.isBlank()) {
            throw new CaesarException("Brutus, the Senate cannot record a nameless task!");
        }
        myTasks.add(new Todo(argument));
        addTaskMessage(myTasks);
    }

    private static void addDeadline(
            ArrayList<Task> myTasks,
            String argument) throws CaesarException {
        if (argument.isBlank()) {
            throw new CaesarException("Brutus, the Senate cannot record a nameless task!");
        }
        if (!argument.contains("/by")) {
            throw new CaesarException("Brutus, use the format: deadline [task] /by [date].");
        }
        String[] parts = argument.split("/by", 2);
        String description = parts[0].trim();
        String date = parts[1].trim();

        if (description.isBlank()) {
            throw new CaesarException("Brutus, the Senate cannot record a nameless task!");
        }
        if (date.isBlank()) {
            throw new CaesarException("Brutus, a deadline without a time is just a wish!");
        }
        myTasks.add(new Deadline(description, date));
        addTaskMessage(myTasks);
    }

    private static void addEvent(
            ArrayList<Task> myTasks,
            String argument) throws CaesarException {
        if (argument.isBlank()) {
            throw new CaesarException("Brutus, use the format: event [task] /from [date] /to [date]");
        }
        if (!argument.contains("/from")) {
            throw new CaesarException("Brutus, the event needs a start time! Use /from.");
        }

        String[] parts = argument.split("/from", 2);
        String description = parts[0].trim();

        if (description.isBlank()) {
            throw new CaesarException("Brutus, the Senate cannot record a nameless task!");
        }
        if (!parts[1].contains("/to")) {
            throw new CaesarException("Brutus, the event needs an end time! Use /to.");
        }

        String[] fromToString = parts[1].split("/to", 2);
        String startDate = fromToString[0].trim();
        String endDate = fromToString[1].trim();

        if (startDate.isBlank() || endDate.isBlank()) {
            throw new CaesarException("Brutus, an event without a start or an end is just a wish!");
        }

        myTasks.add(new Event(description, startDate, endDate));
        addTaskMessage(myTasks);
    }

    private static void addTaskMessage(ArrayList<Task> myTasks) {
        Task t = myTasks.get(myTasks.size() - 1);
        System.out.println("The Senate acknowledges this task:");
        System.out.println("    " + t);
        System.out.println("Now you have " + myTasks.size() + " task(s) in the records.");
    }

    private static void nextCommandPrompt() {
        System.out.println("What else shall we conquer today?");
    }

    private static void deleteTask(
            ArrayList<Task> myTasks,
            String argument) throws CaesarException {
        if (argument.isBlank()) {
            throw new CaesarException("Brutus, the Senate cannot delete a nameless task!");
        }

        int idx;
        try {
            idx = Integer.parseInt(argument) - 1;
        } catch (NumberFormatException e) {
            throw new CaesarException("Mark Antony, that's not a valid number!");
        }

        if (idx < 0 || idx >= myTasks.size()) {
            throw new CaesarException("Mark Antony, that task doesn't exist in our records! Check your list!");
        }
        System.out.println("The Senate has voted to destroy this evil:");
        System.out.println("    " + myTasks.get(idx));
        myTasks.remove(idx);
    }
}
