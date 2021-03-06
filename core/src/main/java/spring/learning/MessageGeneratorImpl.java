package spring.learning;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class MessageGeneratorImpl implements MessageGenerator{

    //region Fields
    private final Game game;
    //endregion

    //region public methods
    @Autowired
    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    @PostConstruct
    public void postConstruct()
    {
        log.info("Game: {}", game);
    }

    @Override
    public String getMainMessage() {
        return "Number is between " +
                game.getSmallest() +
                " and " +
                game.getBiggest() +
                ". Can you guess it?";

    }

    @Override
    public String getResultMessage() {
       if (game.isGameWon())
       {
           return "You guessed the number!";
       }
       else if (game.isGameLost())
       {
           return "Wrong! Try again ;)";
       }
       else if (!game.isValidNumberRange())
       {
           return "Invalid number range!";
       }
       else if (game.getRemainingGuesses() == game.getGuessCount())
       {
           return "What is your first guess?";
       }
       else
       {
           String direction = "Lower";

           if (game.getGuess() < game.getNumber())
           {
               direction = "Higher";
           }

           return direction + "! You have " + game.getRemainingGuesses() + " guesses left.";
       }
    }
    //endregion
}
