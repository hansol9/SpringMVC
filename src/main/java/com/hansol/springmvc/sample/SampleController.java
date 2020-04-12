package com.hansol.springmvc.sample;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.awt.*;

@RestController
public class SampleController {

    /*
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "hello " + name;
    }
    */

    /*
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") Person person) {
        return "hello " + person.getName();
    }
    */

    //preHandler 1
    //preHandler 2
    //request processing
    //postHandler 2
    //postHandler 1
    //view rendering
    //afterCompletion 2
    //afterCompletion 1

    @GetMapping("/hello")
    public String hello(@RequestParam("id") Person person) {

        return "hello " + person.getName();
    }

    @GetMapping("/message")
    public String message(@RequestBody String body) {
        return body;
    }

    @GetMapping("/jsonMessage")
    public Person jsonMessage(@RequestBody Person person) {
        return person;
    }

    @GetMapping("/xmlMessage")
    public Person xmlMessage(@RequestBody Person person) {
        return person;
    }

    @GetMapping("/events")
    @ResponseBody
    public String events() {
        return "events";
    }

    @GetMapping("/events/{id}")
    @ResponseBody
    public String getEventsWithId(@PathVariable Long id) {
        return "events" + id;
    }

    @PostMapping(
            value = "/events",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public String createEvent() {
        return "event";
    }

    @DeleteMapping("/events/{id}")
    @ResponseBody
    public String getDeleteEventsWithId(@PathVariable Long id) {
        return "events" + id;
    }

    @PutMapping(
            value = "/events/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public String getPutEventsWithID(@PathVariable Long id) {
        return "events" + id;
    }

}
