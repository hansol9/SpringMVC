package com.hansol.springmvc;

import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {

    public List<Event> getEvents() {
        Event event1 = Event.builder()
                .name("Spring Web MVC Study 1st")
                .limitOfEnrollment(5)
                .startDateTime(LocalDateTime.of(2019,1,10,10,0))
                .endDateTime(LocalDateTime.of(2019,2,1,10,0))
                .build();

        Event event2 = Event.builder()
                .name("Spring Web MVC Study 2nd")
                .limitOfEnrollment(5)
                .startDateTime(LocalDateTime.of(2020,3,10,10,0))
                .endDateTime(LocalDateTime.of(2020,4,1,10,0))
                .build();

        return List.of(event1, event2);

    }
}
