package com.hansol.springmvc.sample;

import org.springframework.web.bind.annotation.*;

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

}
