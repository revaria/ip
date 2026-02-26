package caesar.storage;

import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import caesar.exception.CaesarException;
import caesar.task.Deadline;
import caesar.task.Event;
import caesar.task.Task;
import caesar.task.Todo;

import java.util.ArrayList;

public class Storage {
    private File file;

    public Storage() {
        String home = System.getProperty("user.home");
        java.nio.file.Path filepath = java.nio.file.Paths.get(home, "data", "caesar.txt");
        this.file = new File(filepath.toString());
    }

    public void save(ArrayList<Task> tasks) throws CaesarException {
        try {
            // Ensure the directory exists
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }

            // Open FileWriter in REWRITE mode
            FileWriter writer = new FileWriter(file);

            for (Task t : tasks) {
                writer.write(t.toSaveFormat() + System.lineSeparator());
            }

            writer.close();
        } catch (IOException e) {
            throw new CaesarException("The Senate's records are inaccessible, Brutus!");
        }
    }

    public ArrayList<Task> load() throws CaesarException {
        ArrayList<Task> loadedTasks = new ArrayList<>();

        if (!file.exists()) {
            return loadedTasks; // Return empty list if no file exists yet
        }

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Logic to turn string back into Task objects goes here
                loadedTasks.add(parseTaskFromLine(line));
            }
            scanner.close();
        } catch (IOException e) {
            throw new CaesarException("The ancient scrolls are unreadable!");
        }
        return loadedTasks;
    }

    private Task parseTaskFromLine(String line) {
        String[] parts = line.split(" \\| ");
        String type = parts[0];
        boolean isDone = parts[1].equals("1");
        String description = parts[2];

        Task t;
        switch (type) {
            case "T":
                t = new Todo(description);
                break;
            case "D":
                t = new Deadline(description, parts[3]);
                break;
            case "E":
                t = new Event(description, parts[3], parts[4]);
                break;
            default:
                return null;
        }

        if (isDone)
            t.markAsDone();
        return t;
    }

}
