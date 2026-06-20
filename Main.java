import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();
        File file = new File("players.txt");
        if (file.exists()) {
         try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
               String line = fileScanner.nextLine();
               String[] parts = line.split(",");
               String name = parts[0];
               String team = parts[1];
               double battingAverage = Double.parseDouble(parts[2]);
               int homeRuns = Integer.parseInt(parts[3]);
               Player loadedPlayer = new Player(name, team, battingAverage, homeRuns);
               players.add(loadedPlayer);
            }
            fileScanner.close();
         } catch (Exception e) {
            System.out.println("Error loading file");
         }
        }

        boolean running = true;
        while (running) {
            System.out.println("1. Add Player");
            System.out.println("2. View All Players");
            System.out.println("3. Search Players");
            System.out.println("4. Sort Players ");
            System.out.println("5. Delete Player ");
            System.out.println("6. Exit ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: 
                  try {
                     System.out.println("Enter player name: ");
                     String name = scanner.nextLine();
                     System.out.println("Enter player team: ");
                     String team = scanner.nextLine();
                     System.out.println("Enter player batting average: ");
                     double battingAverage = Double.parseDouble(scanner.nextLine());
                     System.out.println("Enter player home runs: ");
                     int homeRuns = Integer.parseInt(scanner.nextLine());
                     Player newPlayer = new Player(name, team, battingAverage, homeRuns);
                     players.add(newPlayer);
                  } catch (NumberFormatException e) {
                     System.out.println("Invalid input, player not added");
                  }
                  break;
                case 2:
                   for (Player p : players) {
                     System.out.print(p.getName() + ", ");
                     System.out.print(p.getTeam() + ", ");
                     System.out.print(p.getBattingAverage() + ", ");
                     System.out.print(p.getHomeRuns());
                     System.out.println();
                   }
                   break;
                case 3: 
                   System.out.println("Enter a name to search: ");
                   String searchName = scanner.nextLine();
                   for (Player p : players) {
                     if (p.getName().equals(searchName)) {
                        System.out.println(p.getName() + ", ");
                        System.out.print(p.getTeam() + ", ");
                        System.out.print(p.getBattingAverage() + ", ");
                        System.out.print(p.getHomeRuns());
                        System.out.println();
                        break;
                     }
                   }
                   break;
                case 4:
                   players.sort((p1, p2) -> p2.getHomeRuns() - p1.getHomeRuns());
                   for (Player p : players) {
                     System.out.print(p.getName() + ", ");
                     System.out.print(p.getTeam() + ", ");
                     System.out.print(p.getBattingAverage() + ", ");
                     System.out.print(p.getHomeRuns());
                     System.out.println();
                   }
                   break;
                case 5: 
                   System.out.println("Enter a player to delete: ");
                   String deleteName = scanner.nextLine();
                   for (Player p : players) {
                     if (p.getName().equals(deleteName)) {
                        players.remove(p);
                        break;
                     }
                   }
                   break;
                case 6:
                   try {
                     FileWriter writer = new FileWriter("players.txt");
                     for (Player p : players) {
                        writer.write(p.getName() + "," + p.getTeam() + "," + p.getBattingAverage() + "," + p.getHomeRuns() + "\n");
                     }
                     writer.close();
                  } catch (IOException e) {
                     System.out.println("Error saving file.");
                  }
                   running = false;
                   break;
                default:
            }
        }
    }
}