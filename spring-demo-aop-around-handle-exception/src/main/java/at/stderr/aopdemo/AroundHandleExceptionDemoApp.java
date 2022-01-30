package at.stderr.aopdemo;

import at.stderr.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {

    private static final Logger logger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(DemoConfig.class);
        var fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        logger.info("\nMain Program: AroundDemoApp");
        logger.info("Calling getFortune");

        var tripwire = true;
        String data = fortuneService.getFortune(tripwire);

        logger.info("\nMy fortune is: " + data);
        logger.info("Finished");

        context.close();
    }
}
