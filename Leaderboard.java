package Hackathon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Leaderboard {

    private ArrayList<Player> players;
    private int maxPlayers;

    // Comparator: Higher score first, then earlier achievement time
    private Comparator<Player> comparator = new Comparator<Player>() {
        @Override
        public int compare(Player p1, Player p2) {

            if (p1.getScore() != p2.getScore()) {
                return Integer.compare(p2.getScore(), p1.getScore());
            }

            return Long.compare(p1.getAchievementTime(), p2.getAchievementTime());
        }
    };

    // Constructor
    public Leaderboard(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        players = new ArrayList<>();
    }

    // Add Player
    public void addPlayer(Player player) {

        if (players.size() >= maxPlayers) {
            System.out.println("\n❌ Game is Full!");
            return;
        }

        players.add(player);
        Collections.sort(players, comparator);

        System.out.println("\n✅ Player Added Successfully.");
    }

    // Remove Player
    public void removePlayer(String playerId) {

        for (Player player : players) {

            if (player.getPlayerId().equalsIgnoreCase(playerId)) {

                players.remove(player);

                System.out.println("\n✅ Player Removed Successfully.");
                return;
            }
        }

        System.out.println("\n❌ Player Not Found.");
    }

    // Update Score
    public void updatePlayerScore(String playerId, int newScore) {

        for (Player player : players) {

            if (player.getPlayerId().equalsIgnoreCase(playerId)) {

                player.setScore(newScore);
                player.updateAchievementTime();

                Collections.sort(players, comparator);

                System.out.println("\n✅ Score Updated Successfully.");
                return;
            }
        }

        System.out.println("\n❌ Player Not Found.");
    }

    // Search Player
    public void searchPlayer(String playerId) {

        int rank = 1;

        for (Player player : players) {

            if (player.getPlayerId().equalsIgnoreCase(playerId)) {

                System.out.println("\n========== PLAYER DETAILS ==========");
                System.out.println("Rank : " + rank);
                System.out.println("ID   : " + player.getPlayerId());
                System.out.println("Name : " + player.getPlayerName());
                System.out.println("Score: " + player.getScore());
                return;
            }

            rank++;
        }

        System.out.println("\n❌ Player Not Found.");
    }

    // Display Leaderboard
    public void displayLeaderboard() {

        if (players.isEmpty()) {
            System.out.println("\nNo Players Available.");
            return;
        }

        System.out.println("\n============= LEADERBOARD =============");
        System.out.printf("%-5s %-8s %-15s %-8s\n",
                "Rank", "ID", "Name", "Score");

        int rank = 1;

        for (Player player : players) {

            System.out.printf("%-5d %-8s %-15s %-8d\n",
                    rank++,
                    player.getPlayerId(),
                    player.getPlayerName(),
                    player.getScore());
        }
    }

    // Top N Players
    public void displayTopPlayers(int n) {

        if (players.isEmpty()) {
            System.out.println("\nNo Players Available.");
            return;
        }

        System.out.println("\n========== TOP " + n + " PLAYERS ==========");

        int limit = Math.min(n, players.size());

        for (int i = 0; i < limit; i++) {

            Player p = players.get(i);

            System.out.println((i + 1) + ". "
                    + p.getPlayerName()
                    + " ("
                    + p.getScore()
                    + ")");
        }
    }

    // Statistics
    public void showStatistics() {

        if (players.isEmpty()) {
            System.out.println("\nNo Players Available.");
            return;
        }

        int highest = players.get(0).getScore();
        int lowest = players.get(players.size() - 1).getScore();

        int total = 0;

        for (Player player : players) {
            total += player.getScore();
        }

        double average = (double) total / players.size();

        System.out.println("\n========== GAME STATISTICS ==========");
        System.out.println("Current Players : " + players.size());
        System.out.println("Maximum Players : " + maxPlayers);
        System.out.println("Highest Score   : " + highest);
        System.out.println("Lowest Score    : " + lowest);
        System.out.printf("Average Score   : %.2f\n", average);
    }

    // Current Player Count
    public int getCurrentPlayers() {
        return players.size();
    }

    // Maximum Player Limit
    public int getMaxPlayers() {
        return maxPlayers;
    }

    // Get Player List
    public ArrayList<Player> getPlayers() {
        return players;
    }
}