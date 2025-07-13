package adapters.rest.in;

import application.port.in.PlayTennisGameUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/tennis")
public class PointRestController {

    private static final Logger logger = LoggerFactory.getLogger(PointRestController.class);

    private final PlayTennisGameUseCase playTennisGameUseCase;

    public PointRestController(PlayTennisGameUseCase playTennisGameUseCase) {
        this.playTennisGameUseCase = playTennisGameUseCase;
    }

    @PostMapping("/play")
    public ResponseEntity<String> playGame(@RequestParam("sequence") String sequence) {
        if (!isValidSequence(sequence)) {
            String errorMessage = "Invalid input. Only characters 'A' and 'B' are allowed.";
            logger.warn("Invalid sequence received: {}", sequence);
            return ResponseEntity.badRequest().body(errorMessage);
        }

        String result = playTennisGameUseCase.playGame(sequence);
        return ResponseEntity.ok(result);
    }

    private boolean isValidSequence(String sequence) {
        return sequence != null && sequence.matches("[AB]+");
    }
}
