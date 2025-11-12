package com.example.Springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Primary
// @Lazy
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TrackCoach implements Coach {
    public TrackCoach() {
        System.out.println("In Constructor : "+getClass().getSimpleName() );
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }
}
