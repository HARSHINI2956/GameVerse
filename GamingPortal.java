package Hackathon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GamingPortal {

    private HashMap<Integer, Game> games;
    private Scanner sc;

    public GamingPortal() {

        games = new HashMap<>();
        sc = new Scanner(System.in);

        initializeGames();
    }

    // Initialize all games
    private void initializeGames() {

        games.put(1, new Game("Subway Surfers", 30));
        games.put(2, new Game("Among Us", 15));
        games.put(3, new Game("Free Fire", 50));
        games.put(4, new Game("PUBG", 100));
        games.put(5, new Game("Asphalt 9", 20));
        games.put(6, new Game("Ludo", 4));
        games.put(7, new Game("Smash Cards", 8));
        games.put(8, new Game("Puzzle", 10));
        games.put(9, new Game("Sudoku", 2));
        games.put(10, new Game("Chess", 2));
    }
    // Main Menu
    public void startPortal() {

        while (true) {

            System.out.println("\n========================================");
            System.out.println("        REAL TIME GAMING PORTAL");
            System.out.println("========================================");

            for (Map.Entry<Integer, Game> entry : games.entrySet()) {

                Game game = entry.getValue();

                System.out.println(entry.getKey() + ". "
                        + game.getGameName()
                        + " ("
                        + game.getLeaderboard().getCurrentPlayers()
                        + "/"
                        + game.getMaxPlayers()
                        + ")");
            }

            System.out.println("11. Exit");

            System.out.print("\nChoose Game : ");

            int choice = sc.nextInt();

            if (choice == 11) {

                System.out.println("\nThank You!");
                break;
            }

            Game selectedGame = games.get(choice);

            if (selectedGame != null) {

                gameMenu(selectedGame);

            } else {

                System.out.println("Invalid Choice.");
            }

        }

    }
    // Game Menu
    private void gameMenu(Game game) {

        while (true) {

            System.out.println("\n====================================");
            System.out.println("Game : " + game.getGameName());
            System.out.println("Players : "
                    + game.getLeaderboard().getCurrentPlayers()
                    + "/"
                    + game.getMaxPlayers());
            System.out.println("====================================");

            System.out.println("1. Add Player");
            System.out.println("2. Remove Player");
            System.out.println("3. Update Player Score");
            System.out.println("4. Search Player");
            System.out.println("5. View Leaderboard");
            System.out.println("6. View Top N Players");
            System.out.println("7. View Statistics");
            System.out.println("8. Back");

            System.out.print("\nEnter Choice : ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addPlayer(game);
                    break;

                case 2:
                    removePlayer(game);
                    break;

                case 3:
                    updateScore(game);
                    break;

                case 4:
                    searchPlayer(game);
                    break;

                case 5:
                    game.getLeaderboard().displayLeaderboard();
                    break;

                case 6:

                    System.out.print("Enter N : ");

                    int n = sc.nextInt();

                    game.getLeaderboard().displayTopPlayers(n);

                    break;

                case 7:

                    game.getLeaderboard().showStatistics();

                    break;

                case 8:

                    return;

                default:

                    System.out.println("Invalid Choice.");
            }

        }

    }
    // Add Player
    private void addPlayer(Game game) {

        System.out.print("Enter Player ID : ");
        String id = sc.next();

        sc.nextLine();

        System.out.print("Enter Player Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Score : ");
        int score = sc.nextInt();

        Player player = new Player(id, name, score);

        game.getLeaderboard().addPlayer(player);

    }

    // Remove Player
    private void removePlayer(Game game) {

        System.out.print("Enter Player ID : ");

        String id = sc.next();

        game.getLeaderboard().removePlayer(id);

    }

    // Update Score
    private void updateScore(Game game) {

        System.out.print("Enter Player ID : ");

        String id = sc.next();

        System.out.print("Enter New Score : ");

        int score = sc.nextInt();

        game.getLeaderboard().updatePlayerScore(id, score);

    }

    // Search Player
    private void searchPlayer(Game game) {

        System.out.print("Enter Player ID : ");

        String id = sc.next();

        game.getLeaderboard().searchPlayer(id);

    }
}