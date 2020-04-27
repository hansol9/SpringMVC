package com.hansol.springmvc.handler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getEvent() throws Exception {
        mockMvc.perform(get("/events/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1))
        ;
    }

    @Test
    public void getEventWithMatrixVariables() throws Exception {
        mockMvc.perform(get("/events/1;name=hansol9"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1))
        ;
    }

    @Test
    public void getParam() throws Exception {
//        mockMvc.perform(post("/events?name=hansol9"))
        mockMvc.perform(post("/events")
                    .param("name", "hansol9")
                    .param("limit", "20"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("hansol9"))
        ;
    }

    @Test
    public void eventForm() throws Exception {
        MockHttpServletRequest request = mockMvc.perform(get("/events/form"))
                .andDo(print())
                .andExpect(view().name("events/form"))
                .andExpect(model().attributeExists("event"))
                .andExpect(request().sessionAttribute("event", notNullValue()))
                .andReturn().getRequest();

        Object event = request.getSession().getAttribute("event");
        System.out.println(event);
    }

    @Test
    public void postEvent() throws Exception {
        ResultActions result = mockMvc.perform(post("/events")
                .param("name", "hansol9")
                .param("limit", "-10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().hasErrors());
//                .andExpect(jsonPath("name").value("hansol9"))
        ModelAndView modelAndView = result.andReturn().getModelAndView();
        Map<String, Object> model = modelAndView.getModel();
        System.out.println(model.size());
    }

}