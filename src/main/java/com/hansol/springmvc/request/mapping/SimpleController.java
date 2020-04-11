package com.hansol.springmvc.request.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {

//    @RequestMapping(value = "/hello", method = RequestMethod.GET)       // single method
    @RequestMapping(value = "/hello", method = { RequestMethod.GET, RequestMethod.PUT})
    @ResponseBody
    public String hello() {
        return "hello";
    }
}
