package com.LearningSpringBoot.demo.mycoolapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.LearningSpringBoot.demo.mycoolapp.Coach;
import com.LearningSpringBoot.demo.mycoolapp.SwimCoach;

@Configuration
public class SportConfig {

    // @Bean()
    @Bean("swimCoach")
    public Coach swimCoach() {
        return new SwimCoach();
    }

}
