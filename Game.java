package Hackathon;

public class Game {

    private String gameName;
    private int maxPlayers;
    private Leaderboard leaderboard;

    // Constructor
    public Game(String gameName, int maxPlayers) {

        this.gameName = gameName;
        this.maxPlayers = maxPlayers;

        // Create a leaderboard for this game
        leaderboard = new Leaderboard(maxPlayers);
    }

    // Get Game Name
    public String getGameName() {
        return gameName;
    }

    // Get Maximum Players
    public int getMaxPlayers() {
        return maxPlayers;
    }

    // Get Leaderboard
    public Leaderboard getLeaderboard() {
        return leaderboard;
    }

    // Display Game Information
    public void displayGameInfo() {

        System.out.println("\n========================================");
        System.out.println("Game Name        : " + gameName);
        System.out.println("Maximum Players  : " + maxPlayers);
        System.out.println("Current Players  : "
                + leaderboard.getCurrentPlayers());
        System.out.println("========================================");
    }

    // Check if Game is Full
    public boolean isFull() {

        return leaderboard.getCurrentPlayers() >= maxPlayers;
    }

    @Override
    public String toString() {

        return String.format("%-20s %3d/%-3d Players",
                gameName,
                leaderboard.getCurrentPlayers(),
                maxPlayers);
    }
}