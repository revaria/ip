package caesar;

import caesar.task.*;
import caesar.ui.*;
import caesar.parser.*;
import caesar.exception.*;
import caesar.storage.*;
import java.util.ArrayList;

public class Caesar {

    public static void main(String[] args) {
        Ui ui = new Ui();
        ui.greet();

        ArrayList<Task> myTasks;
        Storage storage = new Storage();
        try {
            myTasks = storage.load();
        } catch (CaesarException e) {
            System.out.println(e.getMessage());
            myTasks = new ArrayList<>();
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
