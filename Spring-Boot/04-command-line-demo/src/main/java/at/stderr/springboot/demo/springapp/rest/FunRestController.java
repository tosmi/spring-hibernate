package at.stderr.springboot.demo.springapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello World! Server time is " + LocalDateTime.now();
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 15k!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is you lucky day!";
    }


}
