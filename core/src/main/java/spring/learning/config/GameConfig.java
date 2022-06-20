package spring.learning.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import spring.learning.qualifiers.GuessCount;
import spring.learning.qualifiers.MaxNumber;
import spring.learning.qualifiers.MinNumber;

@Configuration
@PropertySource("classpath:config/game.properties")
@ComponentScan(basePackages = "spring.learning")
public class GameConfig {
    @Value("${game.maxNumber:50}")
    private int maxNumber;

    @Value("${game.minNumber:0}")
    private int minNumber;

    @Value("${game.guessCount:5}")
    private int guessCount;

    @Bean
    @MaxNumber
    public int maxNumber()
    {
        return maxNumber;
    }

    @Bean
    @MinNumber
    public int minNumber()
    {
        return minNumber;
    }

    @Bean
    @GuessCount
    public int guessCount()
    {
        return guessCount;
    }
}
