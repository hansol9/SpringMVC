package com.hansol.springmvc.request.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping(method = RequestMethod.GET)
public class SimpleController {

//    @RequestMapping(value = "/hello", method = RequestMethod.GET)       // single method
//    @RequestMapping(value = {"/hello", "/hi", "/say"} , method = { RequestMethod.GET, RequestMethod.PUT})
    @GetHelloMapping
    @ResponseBody
    public String hello() {
        return "hello";
    }

//    @RequestMapping(value="/hello?", method = RequestMethod.GET)
//    @RequestMapping(value="/hello/*", method = RequestMethod.GET)
    @RequestMapping(value="/hello/**", method = RequestMethod.GET)
    @ResponseBody
    public String uri() {
        return "hello";
    }
}
