import java.util.Arrays;
import java.util.Scanner;

public class Caesar {
    public static void main(String[] args) {
        String logo = " _____ \n"
                + "/  ___\\ _____  _____  _____  __ __  _____ \n"
                + "| |    /     |/ / _ \\/ /___\\/     |/  ___\\ \n"
                + "| !    | [@] | <  __/\\___\\ \\| [@] || | \n"
                + "| \\___ \\____,?\\_\\___|\\_____/\\_ __,?|_|\n"
                + "\\_____/ \n";
        System.out.println("Hello Brutus, I'm\n" + logo);

        System.out.println("What shall we conquer today?");
        System.out.println("__________________________________________________________");

        String[] tasks = new String[100];
        int task_count = 0;
        String bye_String = "bye";
        String list_String = "list";

        String line;
        Scanner in = new Scanner(System.in);
        while(true) {
            line = in.nextLine();
            if (line.trim().equals(bye_String)) {
                break;
            }
            else if(line.trim().equals(list_String)){
                String[] recorded_tasks = Arrays.copyOf(tasks, task_count);
                for (int j = 0; j < task_count; j++) {
                    System.out.println((j+1) + ": " + recorded_tasks[j]);
                }
            }
            else {
                tasks[task_count] = line;
                System.out.println("added: " + line); 
                task_count++;
            } 
            System.out.println("What else shall we conquer today?");
            System.out.println("__________________________________________________________");
                                         
        }
        in.close();
        System.out.println("Goodbye Brutus, the stars speak of our inevitable reunion.");

    }
}