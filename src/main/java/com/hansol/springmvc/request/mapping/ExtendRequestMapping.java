package com.hansol.springmvc.request.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class ExtendRequestMapping {

    @RequestMapping("/{name:[a-z]+}")
    @ResponseBody
    public String hello(@PathVariable String name) {
        return "hello " + name;
    }
}
