package spring.learning;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class MessageGeneratorImpl implements MessageGenerator{

    //region Fields
    private final Game game;
    private final MessageSource messageSource;

    private static final String MAIN_MESSAGE = "game.main.message";
    private static final String WIN_RESULT_MESSAGE = "game.result.won.message";
    private static final String LOST_RESULT_MESSAGE = "game.result.lost.message";
    private static final String INVALID_RESULT_MESSAGE = "game.result.invalid.message";
    private static final String FIRST_RESULT_MESSAGE = "game.result.first.message";
    private static final String HIGHER_RESULT_MESSAGE = "game.result.higher.message";
    private static final String LOWER_RESULT_MESSAGE = "game.result.lower.message";
    private static final String REMAINING_RESULT_MESSAGE = "game.result.remaining.message";
    //endregion

    //region public methods
    @Autowired
    public MessageGeneratorImpl(Game game, MessageSource messageSource) {
        this.game = game;
        this.messageSource = messageSource;
    }

    @PostConstruct
    public void postConstruct()
    {
        log.info("Game: {}", game);
    }

    @Override
    public String getMainMessage() {
        return getMessage(MAIN_MESSAGE, game.getSmallest(), game.getBiggest());
    }

    @Override
    public String getResultMessage() {
       if (game.isGameWon())
       {
           return getMessage(WIN_RESULT_MESSAGE, game.getSmallest(), game.getBiggest());
       }
       else if (game.isGameLost())
       {
           return getMessage(LOST_RESULT_MESSAGE, game.getSmallest(), game.getBiggest());
       }
       else if (!game.isValidNumberRange())
       {
           return getMessage(INVALID_RESULT_MESSAGE, game.getSmallest(), game.getBiggest());
       }
       else if (game.getRemainingGuesses() == game.getGuessCount())
       {
           return getMessage(FIRST_RESULT_MESSAGE, game.getSmallest(), game.getBiggest());
       }
       else
       {
           String direction = getMessage(LOWER_RESULT_MESSAGE);

           if (game.getGuess() < game.getNumber())
           {
               direction = getMessage(HIGHER_RESULT_MESSAGE);
           }

           return direction + " " + getMessage(REMAINING_RESULT_MESSAGE, game.getRemainingGuesses());
       }
    }

    private String getMessage(String code, Object... args)
    {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
    //endregion
}
