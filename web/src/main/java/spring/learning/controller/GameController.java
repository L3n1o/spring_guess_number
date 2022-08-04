package spring.learning.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.learning.service.GameService;
import spring.learning.util.Attributes;
import spring.learning.util.GameMappings;
import spring.learning.util.ViewNames;

@Controller
@Slf4j
public class GameController {
        private final GameService gameService;

        @Autowired
        public GameController(GameService gameService)
        {
                this.gameService = gameService;
        }

        @GetMapping(GameMappings.PLAY)
        public String play(Model model)
        {
                log.info("Model method");
                model.addAttribute(Attributes.MAIN_MESSAGE, gameService.getMainMessage());
                model.addAttribute(Attributes.RESULT_MESSAGE, gameService.getResultMessage());
                log.info("model = {}", model);

                if (gameService.isGameOver())
                {
                        return ViewNames.GAME_OVER;
                }

                return ViewNames.PLAY;
        }

        @PostMapping(GameMappings.PLAY)
        public String processMessage(@RequestParam int guess)
        {
                log.info("guess ={}", guess);
                gameService.checkGuess(guess);
                return GameMappings.REDIRECT_PLAY;
        }


        @GetMapping(GameMappings.RESTART)
        public String restart()
        {
                log.info("Restart method");
                gameService.reset();
                return GameMappings.REDIRECT_PLAY;
        }

        @GetMapping(GameMappings.HOME)
        public String goHome()
        {
                log.info("Go home method");
                gameService.reset();
                return ViewNames.HOME;
        }
}
