package spring.learning;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Console module for game -> console game interface
 */
@Slf4j
@SpringBootApplication
public class App 
{
    //private static final String CONFIG_LOCATION = "beans_old.xml";

    public static void main( String[] args )
    {
        log.info("Guess te number game");

        SpringApplication.run(App.class, args);
    }
}
