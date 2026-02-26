package caesar.storage;

import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import caesar.exception.CaesarException;
import caesar.task.Deadline;
import caesar.task.Event;
import caesar.task.Task;
import caesar.task.Todo;
import caesar.tasklist.TaskList;

/**
 * Handles the loading and saving of tasks to a local file.
 * Encapsulates all file I/O operations for the Caesar application.
 */
public class Storage {
    private File file;

    public Storage() {
        String home = System.getProperty("user.dir");
        java.nio.file.Path filepath = java.nio.file.Paths.get(home, "data", "caesar.txt");
        this.file = new File(filepath.toString());
    }

    /**
     * Saves the current list of tasks to the hard drive.
     * Creates the necessary directory if it does not exist.
     * 
     * @param tasks The TaskList to be archived.
     * @throws CaesarException If the file cannot be written to.
     */
    public void save(TaskList tasks) throws CaesarException {
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

    /**
     * Loads tasks from the local storage file.
     * 
     * @return A TaskList populated with tasks from the file, or an empty TaskList
     *         if no file exists.
     * @throws CaesarException If the file exists but is unreadable or corrupted.
     */
    public TaskList load() throws CaesarException {
        TaskList loadedTasks = new TaskList();

        if (!file.exists()) {
            return loadedTasks; // Return empty list if no file exists yet
        }

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Logic to turn string back into Task objects goes here
                loadedTasks.addTask(parseTaskFromLine(line));
            }
            scanner.close();
        } catch (IOException e) {
            throw new CaesarException("The ancient scrolls are unreadable!");
        }
        return loadedTasks;
    }

    private Task parseTaskFromLine(String line) throws CaesarException {
        try {
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
                    LocalDateTime by = LocalDateTime.parse(parts[3]);
                    t = new Deadline(description, by);
                    break;
                case "E":
                    LocalDateTime from = LocalDateTime.parse(parts[3]);
                    LocalDateTime to = LocalDateTime.parse(parts[4]);
                    t = new Event(description, from, to);
                    break;
                default:
                    throw new CaesarException("Unknown task type in archives");
            }

            if (isDone)
                t.markAsDone();
            return t;
        } catch (DateTimeParseException | ArrayIndexOutOfBoundsException e) {
            throw new CaesarException("The ancient scrolls are corrupted!");
        }
    }

}
