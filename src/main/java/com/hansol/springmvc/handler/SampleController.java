package com.hansol.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    /*
    * Path Variables
    *
    @GetMapping("/events/{id}")
    @ResponseBody
    public Event getEvent(@PathVariable Long id) {

        Event event = new Event();
        event.setId(id);

        return event;
    }
     */

    /*
    * Matrix Variables
    * */
    @GetMapping("/events/{id}")
    @ResponseBody
    public Event getEvent(@PathVariable("id") Long userid, @MatrixVariable String name) {

        Event event = new Event();
        event.setId(userid);
        event.setName(name);
        return event;
    }

}
