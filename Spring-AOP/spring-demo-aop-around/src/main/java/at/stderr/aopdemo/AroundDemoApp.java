package at.stderr.aopdemo;

import at.stderr.aopdemo.dao.AccountDAO;
import at.stderr.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemoApp {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(DemoConfig.class);
        var fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("\nMain Program: AroundDemoApp");
        System.out.println("Calling getFortune");
        String data = fortuneService.getFortune();
        System.out.println("\nMy fortune is: " + data);
        System.out.println("Finished");

        context.close();
    }
}
