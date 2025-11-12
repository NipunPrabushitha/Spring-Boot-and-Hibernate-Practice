package com.example.Springcoredemo.rest;

import com.example.Springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //this can use as field injection(not recommended)
    private Coach myCoach;

    private Coach anotherCoach;

    //constructor injection
    //qualifier annotation
    @Autowired
    public DemoController(@Qualifier("trackCoach") Coach theCoach,
                          @Qualifier("trackCoach") Coach theAnotherCoach) {
        System.out.println("In Constructor : "+getClass().getSimpleName() );
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

//for primary annotation
    /*@Autowired
    public DemoController(Coach theCoach) {
        myCoach = theCoach;
    }*/


    //setter injection
/*    @Autowired
    public void setCoach(Coach thisCoach) {
        myCoach = thisCoach;
    }*/
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }


    @GetMapping("/check")
    public String check() {
        return "Comparing beans : myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }
}
