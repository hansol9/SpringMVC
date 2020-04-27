package com.hansol.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/events/form/name")
    public String eventFormName(Model model) {
        model.addAttribute("event", new Event());
        return "events/form-name";
    }

    @PostMapping("/events/form/name")
    public String eventsFormNameSubmit(@Validated @ModelAttribute Event event,
                              BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "/events/form-name";
        }

        return "redirect:/events/form/limit";
    }

    @GetMapping("/events/form/limit")
    public String eventFormLimit(@ModelAttribute Event event, Model model) {
        model.addAttribute("event", event);
        return "events/form-limit";
    }

    @PostMapping("/events/form/limit")
    public String eventsFormLimitSubmit(@Validated @ModelAttribute Event event,
                                       BindingResult bindingResult,
                                       SessionStatus sessionStatus) {
        if(bindingResult.hasErrors()) {
            return "/events/form-limit";
        }
        sessionStatus.setComplete();
        return "redirect:/events/list_page";
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
            return "form-name";
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
