package caesar.tasklist;

import caesar.task.Task;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a list of tasks for the Caesar application.
 * Provides methods to manipulate the tasks and search through them.
 * Implements {@code Iterable} to allow for-each loops directly on the TaskList.
 */
public class TaskList implements Iterable<Task> {
    private final ArrayList<Task> tasks;

    /**
     * Constructs a TaskList with an existing collection of tasks.
     * 
     * @param tasks An ArrayList of tasks to initialize the list with.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Constructs an empty TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Adds a new task to the collection.
     * 
     * @param task The Task object to be added to the records.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Removes and returns the task at the specified position in this list.
     * 
     * @param index The zero-based index of the task to be removed.
     * @return The task that was removed from the list.
     * @throws IndexOutOfBoundsException If the index is out of range (index < 0 ||
     *                                   index >= size()).
     */
    public Task deleteTask(int index) throws IndexOutOfBoundsException {
        return tasks.remove(index);
    }

    /**
     * Retrieves the task at the specified index.
     * 
     * @param index The zero-based index of the task to retrieve.
     * @return The Task at the given index.
     * @throws IndexOutOfBoundsException If the index is out of range.
     */
    public Task getTask(int index) {
        return tasks.get(index);
    }

    /**
     * Checks if the task list contains any entries.
     * 
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    /**
     * Returns the total number of tasks currently in the list.
     * 
     * @return The size of the internal task collection.
     */
    public int getSize() {
        return tasks.size();
    }

    /**
     * Provides access to the underlying ArrayList of tasks.
     * 
     * @return The ArrayList containing all Task objects.
     */
    public ArrayList<Task> getAllTasks() {
        return tasks;
    }

    /**
     * Searches for tasks that contain any of the provided keywords in their
     * description.
     * The search is case-insensitive.
     * 
     * @param keywords One or more search terms provided by the user.
     * @return A new TaskList containing the tasks that matched at least one
     *         keyword.
     */
    public TaskList findTasks(String... keywords) {
        TaskList matches = new TaskList();
        for (Task task : tasks) {
            String desc = task.getDescription().toLowerCase();
            for (String key : keywords) {
                if (desc.contains(key.toLowerCase())) {
                    matches.addTask(task);
                    break;
                }
            }
        }
        return matches;
    }

    /**
     * Returns an iterator over the tasks in this list in proper sequence.
     * Required for implementing the {@code Iterable} interface.
     * 
     * @return An iterator over the task collection.
     */
    @Override
    public Iterator<Task> iterator() {
        return tasks.iterator();
    }
}
