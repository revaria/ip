package caesar;

import caesar.ui.*;
import caesar.parser.*;
import caesar.exception.*;
import caesar.storage.*;
import caesar.tasklist.TaskList;

public class Caesar {

    public static void main(String[] args) {
        Ui ui = new Ui();
        ui.greet();
        TaskList myTasks;

        Storage storage = new Storage();
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
                isRunning = Parser.handleCommand(line, myTasks, storage);
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
