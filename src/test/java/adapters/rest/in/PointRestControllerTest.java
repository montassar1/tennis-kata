package adapters.rest.in;

import application.port.in.PlayTennisGameUseCase;
import com.example.MainApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PointRestController.class)
@ContextConfiguration(classes = MainApplication.class)

class PointRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayTennisGameUseCase playTennisGameUseCase;

    @Test
    void should_return_400_for_invalid_input() throws Exception {
        mockMvc.perform(post("/tennis/play?sequence=ABC"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Invalid input. Only characters 'A' and 'B' are allowed."));
    }

    @Test
    void should_return_200_and_score_for_valid_input() throws Exception {
        String input = "ABABAA";
        String mockResult = "Player A : 15 / Player B : 0\nPlayer A wins the game";

        when(playTennisGameUseCase.playGame(input)).thenReturn(mockResult);

        mockMvc.perform(post("/tennis/play?sequence=" + input))
                .andExpect(status().isOk())
                .andExpect(content().string(mockResult));
    }
}
