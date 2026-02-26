package caesar.ui;

import caesar.tasklist.TaskList;

import java.util.Scanner;

/**
 * Handles the user interface of the application.
 * Responsible for reading user input and displaying messages to the user.
 */
public class Ui {
    private static final Scanner in = new Scanner(System.in);

    /**
     * Displays the greeting message and Caesar logo to the user.
     */
    public void greet() {
        String logo = " _____ \n"
                + "/  ___\\ _____  _____  _____  __ __  _____ \n"
                + "| |    /     |/ / _ \\/ /___\\/     |/  ___\\ \n"
                + "| !    | [@] | <  __/\\___\\ \\| [@] || | \n"
                + "| \\___ \\____,?\\_\\___|\\_____/\\_ __,?|_|\n"
                + "\\_____/ \n";

        System.out.println("Hello Brutus, I'm\n" + logo);
        System.out.println("What shall we conquer today?");
        System.out.println("==========================================================");
    }

    /**
     * Reads the next line of input from the user and trims whitespace.
     * 
     * @return A trimmed string containing the user's input.
     */
    public String readInput() {
        return in.nextLine().trim();
    }

    /**
     * Closes the internal Scanner resource.
     * Should be called when the application is exiting.
     */
    public void close() {
        in.close();
    }

    /**
     * Prints a horizontal line divider to organize output.
     */
    public void printLineDivider() {
        System.out.println("__________________________________________________________");
    }

    /**
     * Displays the results of a search operation.
     * 
     * @param results A TaskList containing the tasks that matched the search
     *                keywords.
     */
    public void showSearchResults(TaskList results) {
        printLineDivider();
        if (results.isEmpty()) {
            System.out.println("No matching scrolls found in the archives, Brutus.");
        } else {
            System.out.println("Here are the matching tasks in your list:");
            for (int i = 0; i < results.getSize(); i++) {
                System.out.println((i + 1) + "." + results.getTask(i));
            }
        }
        printLineDivider();
    }

    /**
     * Displays all tasks currently in the task list.
     * 
     * @param tasks The TaskList to be displayed.
     */
    public void showTaskList(TaskList tasks) {
        if (tasks.isEmpty()) {
            System.out.println("The Caesar Files are empty!");
            return;
        }
        System.out.println("The Caesar Files are as follows:");
        for (int i = 0; i < tasks.getSize(); i++) {
            System.out.println("    " + (i + 1) + ": " + tasks.getTask(i));
        }
    }
}
