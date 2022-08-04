package spring.learning.util;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ThymeleafParamsAdapter {

    private final String mainMessage = Attributes.MAIN_MESSAGE;
    private final String resultMessage = Attributes.RESULT_MESSAGE;

    private final String play = GameMappings.PLAY;
    private final String redirectPlay = GameMappings.REDIRECT_PLAY;
    private final String restart = GameMappings.RESTART;
    private final String home = GameMappings.HOME;
}
