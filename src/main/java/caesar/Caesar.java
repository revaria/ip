package caesar;

import caesar.ui.Ui;
import caesar.parser.Parser;
import caesar.exception.CaesarException;
import caesar.storage.Storage;
import caesar.tasklist.TaskList;

public class Caesar {
    private static Ui ui = new Ui();
    private static TaskList myTasks;
    private static Storage storage = new Storage();

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
