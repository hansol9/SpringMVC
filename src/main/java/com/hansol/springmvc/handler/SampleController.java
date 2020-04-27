package com.hansol.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("event")
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
    @GetMapping("/events/{id}")
    @ResponseBody
    public Event getEvent(@PathVariable("id") Long userid, @MatrixVariable String name) {

        Event event = new Event();
        event.setId(userid);
        event.setName(name);
        return event;
    }
    */

    @GetMapping("/events/form")
//    public String eventForm(Model model, HttpSession httpSession) {
    public String eventForm(Model model) {
        Event event = new Event();
        event.setLimit(50);
        model.addAttribute("event", event);
//        httpSession.setAttribute("event", event);
        return "events/form";
    }

    /**
     * Simple Parameter
    @PostMapping("/events")
    @ResponseBody
    public Event getEvent(@RequestParam String name, @RequestParam Integer limit) {
        Event event = new Event();
        event.setName(name);
        event.setLimit(limit);
        return event;
    }
    */

    /**
     * Validated Group
     * @param event
     * @param bindingResult
     * @return
    @PostMapping("/events")
    @ResponseBody
    public Event getEvent(@Validated(Event.ValidateName.class) @ModelAttribute Event event, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println("===========================");
            bindingResult.getAllErrors().forEach(objectError -> {
                System.out.println(objectError.toString());
            });
        }
        return event;
    }
     */

    @PostMapping("/events")
    public String createEvent(@Validated @ModelAttribute Event event,
                           BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "/events/form";
        }

        /*
        List<Event> eventList = new ArrayList<>();
        eventList.add(event);
        model.addAttribute("eventList", eventList);
        */

        return "redirect:/events/list_page";
    }

    @GetMapping("/events/list_page")
    public String getEvent(Model model) {
        Event event = new Event();
        event.setName("Spring");
        event.setLimit(10);

        List<Event> eventList = new ArrayList<>();
        eventList.add(event);
        model.addAttribute("eventList", eventList);

        return "/events/list_page";
    }
    /*
    @PostMapping("/events")
    @ResponseBody
    public Event getEvent(@RequestParam Map<String, String> params) {
        Event event = new Event();
        event.setName(params.get("name"));
        return event;
    }
     */

}
