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

        String line;
        Scanner in = new Scanner(System.in);
        while(true) {
            line = in.nextLine();
            if (line.contains("bye")) {
                break;
            }
            System.out.println("You said: " + line);  
            System.out.println("What else shall we conquer today?");
            System.out.println("__________________________________________________________");
                                         
        }
        in.close();
        System.out.println("Goodbye Brutus, the stars speak of our inevitable reunion.");

    }
}