package adapters.rest.in;

import application.usecase.TennisGameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/tennis")
public class PointRestController {

    private static final Logger logger = LoggerFactory.getLogger(PointRestController.class);

    private final TennisGameService tennisGameService;

    public PointRestController(TennisGameService tennisGameService) {
        this.tennisGameService = tennisGameService;
    }

    @PostMapping("/play")
    public ResponseEntity<String> playGame(@RequestParam("sequence") String sequence) {
        if (!isValidSequence(sequence)) {
            String errorMessage = "Invalid input. Only characters 'A' and 'B' are allowed.";
            logger.warn("Invalid sequence received: {}", sequence);
            return ResponseEntity.badRequest().body(errorMessage);
        }

        String result = tennisGameService.playGame(sequence);
        return ResponseEntity.ok(result);
    }

    private boolean isValidSequence(String sequence) {
        return sequence != null && sequence.matches("[AB]+");
    }
}
