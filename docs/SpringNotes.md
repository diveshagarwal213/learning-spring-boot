
<!-- ------------------------------Section TWO -->
# Spring Container
## Primary Functions
+ Create and Manage Objects (Inversion of control)
+ Inject Object Dependencies (Dependency Injection)

### Injection Type
+ Constructor Injection (required dependencies)
+ Setter Injection (optional dependencies)
+ Field Injection (Not recommended)

### AutoWiring 
+ auto include dependencies
+ it will lock for interface or classes with  '@components' annotation
```java
//Constructor Injection
@RestController
public class DemoController {
    private Coach my_coach;
    
    //Behind the sense 
    //Coach theCoach = new CricketCoach();
    //DemoController demoController = new DemoController(theCoach)
    @Autowired // not required due to only one constructor
    public DemoController(Coach theCoach) {
        my_coach = theCoach;
    }

    @GetMapping("/daily_workout")
    public String getDailyWorkout() {
        return my_coach.getDailyWorkout();
    }
}

// Setter Injection
@RestController
public class DemoController {
    private Coach my_coach;

    // Constructor autowired
    // public DemoController(Coach theCoach) {
    // my_coach = theCoach;
    // }

    @Autowired // Autowired is required even if its a single dependency
    public void setCoach(Coach theCoach) {
        my_coach = theCoach;
    }

    @GetMapping("/daily_workout")
    public String getDailyWorkout() {
        return my_coach.getDailyWorkout();
    }
}

// Field Injection
@RestController
public class DemoController {
    @Autowired
    private Coach my_coach;

    // no setter and constructor needed.

    @GetMapping("/daily_workout")
    public String getDailyWorkout() {
        return my_coach.getDailyWorkout();
    }
}

```
### @Qualifier
+ when multiple_implementation use @Qualifier('className') first letter must be lowercase. 
```java
public DemoController(@Qualifier("cricketCoach") Coach theCoach) {
        my_coach = theCoach;
    }
```
### @Primary
```java
@Component
@Primary // if no Qualifier then this will be used
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "getDailyWorkout output 5";
    }

}
```

### @Lazy
```java
@Component
@Lazy // spring will only include this when its required : optimization
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "getDailyWorkout output 5";
    }

}
```
+ For global configuration  
    + spring.main.lazy-initialization=true (in application.properties)


### @Scope
+ singleton ('default')
```java
@Component
@Scope("singleton")
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "getDailyWorkout output 5";
    }

}
```