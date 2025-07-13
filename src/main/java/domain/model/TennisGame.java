package domain.model;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TennisGame {

    private static final Logger logger = LoggerFactory.getLogger(TennisGame.class);

    private final int[] points = {0, 15, 30, 40};
    private int scoreA = 0;
    private int scoreB = 0;
    private boolean isDeuce = false;
    private String advantage = null;
    private boolean gameOver = false;
    private final List<String> result = new ArrayList<>();

    public String computeScore(String input) {
        for (char c : input.toCharArray()) {
            if (gameOver) break;
            if (c == 'A' || c == 'B') {
                updateScore(c);
            } else {
                result.add("Invalid character: " + c);
            }

        }

        String finalResult = String.join("\n", result);
        logger.info("\n{}", finalResult);
        return finalResult;
    }

    private void updateScore(char c) {
        if (isDeuce || (scoreA >= 3 && scoreB >= 3 && scoreA == scoreB)) {
            handleDeuceAndAdvantage(c);
            return;
        }

        if (c == 'A') scoreA++;
        else scoreB++;

        if (scoreA >= 4 && scoreA - scoreB >= 2) {
            result.add("Player A wins the game");
            gameOver = true;
        } else if (scoreB >= 4 && scoreB - scoreA >= 2) {
            result.add("Player B wins the game");
            gameOver = true;
        } else if (scoreA >= 3 && scoreB >= 3 && scoreA == scoreB) {
            isDeuce = true;
            result.add("Deuce");
        } else {
            result.add("Player A : " + points[Math.min(scoreA, 3)] +
                    " / Player B : " + points[Math.min(scoreB, 3)]);
        }
    }

    private void handleDeuceAndAdvantage(char c) {
        if (advantage == null) {
            advantage = String.valueOf(c);
            result.add("Advantage Player " + c);
        } else if (advantage.equals(String.valueOf(c))) {
            result.add("Player " + c + " wins the game");
            gameOver = true;
        } else {
            advantage = null;
            result.add("Deuce");
        }
    }
}
