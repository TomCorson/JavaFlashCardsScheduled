package com.example.schedulingtasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTexts {

    @Scheduled(fixedRate = 10000)
    public void sendTexts(){
        FactRetriever fr = new FactRetriever();
        System.out.println(MakeText.send(fr.retrieveRandomFact()));
    }
}
