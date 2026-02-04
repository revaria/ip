import java.util.ArrayList;
import java.util.Scanner;

public class Caesar {

    public static void main(String[] args) {
        Greeting.Greet();

        ArrayList<Task> myTasks = new ArrayList<>();
        String line;
        Scanner in = new Scanner(System.in);
        boolean isRunning = true;

        // Input + Output loop
        while (isRunning) {
            line = in.nextLine().trim(); // Get user input and remove leading/trailing white spaces
            if (line.isBlank()) { // Skip empty inputs
                continue;
            }
            isRunning = Parser.handleCommand(line, myTasks);
        }

        in.close();
    }
}
