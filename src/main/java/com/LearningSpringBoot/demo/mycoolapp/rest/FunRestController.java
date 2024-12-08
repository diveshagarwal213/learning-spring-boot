package com.LearningSpringBoot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class FunRestController {
    @GetMapping("/")
    public String sayHello() {
        return "Hello world";
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "DailyWorkout";
    }

}
