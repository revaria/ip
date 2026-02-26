package caesar.ui;

import caesar.tasklist.TaskList;

import java.util.Scanner;

public class Ui {
    private static final Scanner in = new Scanner(System.in);

    public void greet() {
        String logo = " _____ \n"
                + "/  ___\\ _____  _____  _____  __ __  _____ \n"
                + "| |    /     |/ / _ \\/ /___\\/     |/  ___\\ \n"
                + "| !    | [@] | <  __/\\___\\ \\| [@] || | \n"
                + "| \\___ \\____,?\\_\\___|\\_____/\\_ __,?|_|\n"
                + "\\_____/ \n";

        // Greeting Message
        System.out.println("Hello Brutus, I'm\n" + logo);
        System.out.println("What shall we conquer today?");
        System.out.println("==========================================================");
    }

    public String readInput() {
        return in.nextLine().trim();
    }

    public void close() {
        in.close();
    }

    public void printLineDivider() {
        System.out.println("__________________________________________________________");
    }

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
}
