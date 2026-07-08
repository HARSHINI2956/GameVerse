package Hackathon;

public class Player {

    private String playerId;
    private String playerName;
    private int score;
    private long achievementTime;

    // Constructor
    public Player(String playerId, String playerName, int score) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.score = score;
        this.achievementTime = System.currentTimeMillis();
    }

    // Getters
    public String getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }

    public long getAchievementTime() {
        return achievementTime;
    }

    // Setters
    public void setScore(int score) {
        this.score = score;
    }

    public void updateAchievementTime() {
        this.achievementTime = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return String.format(
                "%-8s %-15s %-8d %-15d",
                playerId,
                playerName,
                score,
                achievementTime
        );
    }
}