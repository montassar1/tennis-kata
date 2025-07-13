package application.usecase;

import application.port.in.ScoreBallUseCase;
import domain.model.TennisGame;
import org.springframework.stereotype.Service;


@Service
public class TennisGameService implements ScoreBallUseCase {

    private final TennisGame game = new TennisGame();

    @Override
    public String playGame(String input) {
      return  game.computeScore(input);
    }
}