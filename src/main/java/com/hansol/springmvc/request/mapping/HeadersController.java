package com.hansol.springmvc.request.mapping;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HeadersController {

//    @RequestMapping(value = "/hello", headers = "!" + HttpHeaders.FROM)
    @RequestMapping(value = "/hello", headers = HttpHeaders.AUTHORIZATION + "=" + "111")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @RequestMapping(value ="/header", params = "name=hansol")
    @ResponseBody
    public String header() {
        return "header";
    }
}
