import java.util.ArrayList;
import java.util.Scanner;

public class Caesar {

    public static void main(String[] args) {

        ArrayList<Task> myTasks = new ArrayList<>();
        String line;
        Scanner in = new Scanner(System.in);
        boolean isRunning = true;

        Greeting.Greet();

        // Input + Output loop
        while (isRunning) {
            line = in.nextLine().trim(); // Get user input and remove leading/trailing white spaces
            if (line.isEmpty()) { // Skip empty inputs
                continue;
            }
            isRunning = Parser.handleCommand(line, myTasks);
        }
        in.close();
    }
}
