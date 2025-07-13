package application.usecase;

import application.port.in.PlayTennisGameUseCase;
import domain.model.TennisGame;
import org.springframework.stereotype.Service;

@Service
public class PlayTennisGameUseCaseImpl implements PlayTennisGameUseCase {

    @Override
    public String playGame(String input) {

        TennisGame game = new TennisGame();

        return  game.computeScore(input);
    }
}