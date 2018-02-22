package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solimar.domain.Greeting;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private static Logger logger = LoggerFactory.getLogger(GreetingController.class);

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="Fuking World") String name) {
    	
        logger.debug("Seems like the wrong place.");
        logger.warn("Seems like the wrong place.!!");
    	System.out.println("Seems like the wrong place!");
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}