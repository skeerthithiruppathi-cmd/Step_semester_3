package step_week_1.class_problems;

import java.util.Random;

public class RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random random = new Random();

        int n = 5; 
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        String[] computerMoves = new String[n];
        String[] results = new String[n];

        int wins = 0, losses = 0, draws = 0;

        System.out.println("===== Rock Paper Scissors =====");

        for (int i = 0; i < n; i++) {
            computerMoves[i] = moves[random.nextInt(3)];

            results[i] = playRound(playerMoves[i], computerMoves[i]);

            System.out.println("Round " + (i + 1) + " - Player: " + playerMoves[i]
                    + ", Computer: " + computerMoves[i] + " -> " + results[i]);
            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }
        System.out.println("\n----------- Summary Table -----------");
        System.out.printf("%-8s %-14s %-14s %-14s%n", "Round", "Player Move", "Computer Move", "Result");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-8d %-14s %-14s %-14s%n",
                    (i + 1), playerMoves[i], computerMoves[i], results[i]);
        }

        double winPercentage = (wins * 100.0) / n;

        System.out.println("\nWins: " + wins + " | Losses: " + losses + " | Draws: " + draws
                + " | Win % = " + winPercentage + "%");
    }
}