package caesar.ui;

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
}
