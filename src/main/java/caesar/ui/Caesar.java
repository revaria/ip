package caesar.ui;

import caesar.task.*;
import caesar.parser.*;
import caesar.exception.*;
import caesar.storage.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Caesar {

    public static void main(String[] args) {
        Greeting.greet();

        String home = System.getProperty("user.home");
        java.nio.file.Path path = java.nio.file.Paths.get(home, "data", "caesar.txt");

        Storage storage = new Storage(path.toString());
        ArrayList<Task> myTasks;
        // ArrayList<Task> myTasks = new ArrayList<>();
        String line;
        Scanner in = new Scanner(System.in);
        boolean isRunning = true;

        try {
            myTasks = storage.load();
        } catch (CaesarException e) {
            System.out.println(e.getMessage());
            myTasks = new ArrayList<>();
        }

        // Input + Output loop
        while (isRunning) {
            try {
                line = in.nextLine().trim(); // Get user input and remove leading/trailing white spaces
                if (line.isBlank()) { // Skip empty inputs
                    continue;
                }
                isRunning = Parser.handleCommand(line, myTasks, storage);
            } catch (CaesarException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("An unknown error has infiltrated the Senate: " + e.getMessage());
            } finally {
                if (isRunning) {
                    System.out.println("__________________________________________________________");
                }
            }
        }

        in.close();
    }
}
