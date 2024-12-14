package com.LearningSpringBoot.demo.mycoolapp;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "getDailyWorkout output 5";
    }

    @PostConstruct
    public void AfterConstruct() {
        System.out.println("do some thing AfterConstruct");
    }

    @PreDestroy
    public void beforeDestroy() {
        System.out.println("do some thing beforeDestroy");
    }

}
