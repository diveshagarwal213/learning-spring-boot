package com.LearningSpringBoot.demo.mycoolapp;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;

// @RestController
// public class DemoController {
//     // @Autowired
//     private Coach my_coach;

//     // Constructor autowired
//     // @Autowired
//     public DemoController(@Qualifier("cricketCoach") Coach theCoach) {
//         my_coach = theCoach;
//     }

//     // @Autowired // Autowired is required even if its a single dependency
//     // public void setCoach(Coach theCoach) {
//     // my_coach = theCoach;
//     // }

//     @GetMapping("/daily_workout")
//     public String getDailyWorkout() {
//         return my_coach.getDailyWorkout();
//     }
// }

@RestController
public class DemoController {
    // @Autowired
    private Coach my_coach;

    // Constructor autowired
    // @Autowired
    public DemoController(@Qualifier("swimCoach") Coach theCoach) {
        my_coach = theCoach;
    }

    // @Autowired // Autowired is required even if its a single dependency
    // public void setCoach(Coach theCoach) {
    // my_coach = theCoach;
    // }

    @GetMapping("/daily_workout")
    public String getDailyWorkout() {
        return my_coach.getDailyWorkout();
    }
}
