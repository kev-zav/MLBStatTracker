import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();

        boolean running = true;
        while (running) {
            System.out.println("1. Add Player");
            System.out.println("2. View All Players");
            System.out.println("3. Search Players");
            System.out.println("4. Sort Players ");
            System.out.println("5. Delete Player ");
            System.out.println("6. Exit ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: 
                   // option 1 placeholder
                   break;
                case 2:
                   // option 2 placeholder
                   break;
                case 3: 
                   // option 3 placeholder
                   break;
                case 4:
                    // option 4 placeholder
                   break;
                case 5: 
                   // option 5 placeholder
                   break;
                case 6:
                   running = false;
                   break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}