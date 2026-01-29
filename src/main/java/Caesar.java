import java.util.ArrayList;
import java.util.Scanner;

public class Caesar {
    
    public static void main(String[] args) {

        final String byeString = "bye";
        final String listString = "list";
        final String markString = "mark";
        final String unmarkString = "unmark";

        ArrayList<Task> myTasks = new ArrayList<>();
        String line;
        Scanner in = new Scanner(System.in);
        boolean isRunning = true;

        String logo = " _____ \n"
                + "/  ___\\ _____  _____  _____  __ __  _____ \n"
                + "| |    /     |/ / _ \\/ /___\\/     |/  ___\\ \n"
                + "| !    | [@] | <  __/\\___\\ \\| [@] || | \n"
                + "| \\___ \\____,?\\_\\___|\\_____/\\_ __,?|_|\n"
                + "\\_____/ \n";

        // Greeting Message
        System.out.println("Hello Brutus, I'm\n" + logo);
        System.out.println("What shall we conquer today?");
        System.out.println("__________________________________________________________");

        // Input + Output loop
        while(isRunning) {
            line = in.nextLine().trim(); // Get user input and remove leading/trailing white spaces
            if (line.isEmpty()) { // Skip empty inputs
                continue;
            }
            
            // Process user input into two parts
            String[] parts = line.split(" ", 2);
            String command = parts[0].toLowerCase();
            String argument = (parts.length > 1) ? parts[1].trim() : "";

            // Determine action taken based on user input
            switch (command) {
                case byeString: // Exit loop immediately
                    isRunning = false;
                    continue;
                case listString: // Print the list of all tasks
                    int size = Task.getTaskCount();
                    for (int i = 0; i < size; i++) {
                        System.out.println((i+1) + ": " + myTasks.get(i).toString());
                    }
                    break;
                case markString: // Mark task as complete
                    try {
                        int id_m = Integer.parseInt(argument) - 1;
                        myTasks.get(id_m).markAsDone();
                        System.out.println("Marking:");
                        System.out.println((id_m + 1) + ": " + myTasks.get(id_m).toString());
                    } catch (NumberFormatException e) {
                        System.out.println("Mark Antony, that's not a valid number! Try 'mark 1'.");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Mark Antony, we haven't conquered that many tasks yet! Check your 'list'.");
                    }
                    break;
                case unmarkString: // Mark task as incomplete
                    try {
                        int id_u = Integer.parseInt(argument) - 1;
                        myTasks.get(id_u).markAsUndone();
                        System.out.println("Unmarked Antony? Ha ha ha. Unmarking:");
                        System.out.println((id_u + 1) + ": " + myTasks.get(id_u).toString());
                    } catch (NumberFormatException e) {
                        System.out.println("Mark Antony, that's not a valid number! Try 'mark 1'.");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Mark Antony, we haven't conquered that many tasks yet! Check your 'list'.");
                    }
                    break;
                default: // Add new task
                    myTasks.add(new Task(line));
                    System.out.println("added: " + line); 
                    break;
            }

            System.out.println("What else shall we conquer today?");
            System.out.println("__________________________________________________________");                             
        }
        in.close();

        // Goodbye Message
        System.out.println("Goodbye Brutus, the stars speak of our inevitable reunion.");
    }
}