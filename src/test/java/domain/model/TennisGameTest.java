
package domain.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TennisGameTest {

    @Test
    void should_return_expected_score_for_sequence_ABABAA() {
        TennisGame game = new TennisGame();

        String input = "ABABAA";
        String expected = String.join("\n", new String[]{
                "Player A : 15 / Player B : 0",
                "Player A : 15 / Player B : 15",
                "Player A : 30 / Player B : 15",
                "Player A : 30 / Player B : 30",
                "Player A : 40 / Player B : 30",
                "Player A wins the game"
        });

        String result = game.computeScore(input);
        assertEquals(expected, result);
    }

    @Test
    void should_return_deuce_and_advantage_then_win() {
        TennisGame game = new TennisGame();

        String input = "ABABABBAAA"; // va jusqu'à Deuce → Advantage A → win
        String expected = String.join("\n", new String[]{
                "Player A : 15 / Player B : 0",
                "Player A : 15 / Player B : 15",
                "Player A : 30 / Player B : 15",
                "Player A : 30 / Player B : 30",
                "Player A : 40 / Player B : 30",
                "Deuce",  // ✅ correction ici
                "Advantage Player B",
                "Deuce",
                "Advantage Player A",
                "Player A wins the game"
        });

        String result = game.computeScore(input);
        assertEquals(expected, result);
    }

    @Test
    void should_return_win_for_player_B() {
        TennisGame game = new TennisGame();
        String input = "BBBAAABB"; // Player B l'emporte
        String result = game.computeScore(input);

        assertTrue(result.contains("Player B wins the game"));
    }
}
