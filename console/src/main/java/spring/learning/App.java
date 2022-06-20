package spring.learning;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.learning.config.GameConfig;

/**
 * Console module for game -> console game interface
 */
@Slf4j
public class App 
{
    //private static final String CONFIG_LOCATION = "beans_old.xml";

    public static void main( String[] args )
    {
        log.info("Guess te number game");

        // create context (container)
        ConfigurableApplicationContext context
                //= new ClassPathXmlApplicationContext(CONFIG_LOCATION);
                = new AnnotationConfigApplicationContext(GameConfig.class);

        // close context
        context.close();
    }
}
