package caesar;

import caesar.ui.Ui;
import caesar.parser.Parser;
import caesar.exception.CaesarException;
import caesar.storage.Storage;
import caesar.tasklist.TaskList;

/**
 * Entry point for the Caesar task management application.
 * Coordinates the interactions between the UI, Storage, Parser, and TaskList
 * components.
 */
public class Caesar {
    private static Ui ui = new Ui();
    private static TaskList myTasks;
    private static Storage storage = new Storage();

    /**
     * Starts the Caesar application.
     * Initializes the UI, loads existing tasks from storage, and enters the main
     * command loop.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        ui.greet();
        try {
            myTasks = storage.load();
        } catch (CaesarException e) {
            System.out.println(e.getMessage());
            myTasks = new TaskList();
        }

        boolean isRunning = true;
        while (isRunning) {
            try {
                String line = ui.readInput();
                if (line.isBlank()) {
                    continue;
                }
                isRunning = Parser.handleCommand(line, myTasks, storage, ui);
            } catch (CaesarException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("An unknown error has infiltrated the Senate: " + e.getMessage());
            } finally {
                ui.printLineDivider();
            }
        }

        ui.close();
    }
}
