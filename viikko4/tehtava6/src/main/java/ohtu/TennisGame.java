package ohtu;

public class TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (player1.getName() == playerName) {
            player1.incrementScore();
        } else {
            player2.incrementScore();
        }
    }

    private String getScoreName(int score) {        
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "";
        }
    }

    private String tiedScore(int score) {
        if (score < 4) {
            return getScoreName(score) + "-All";
        }
        return "Deuce";
    }

    private String leadingScore(Player leadingPlayer) {
        if (leadingPlayer.getScore() < 4) {
            return getScoreName(player1.getScore()) + "-" + getScoreName(player2.getScore());
        }
        if (Math.abs(player1.getScore() - player2.getScore()) < 2) {
            return "Advantage " + leadingPlayer;
        }
        return "Win for " + leadingPlayer;
    }

    public String getScore() {
        if (player1.getScore() > player2.getScore()) {
            return leadingScore(player1);
        }
        if (player1.getScore() < player2.getScore()) {
            return leadingScore(player2);
        }
        return tiedScore(player1.getScore());
    }
}
