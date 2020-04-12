package com.hansol.springmvc.exercise;

import com.hansol.springmvc.sample.SampleController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class ExerciseControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getEvents() throws Exception {

        this.mockMvc.perform(get("/events"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getEventsWithId() throws Exception {

        this.mockMvc.perform(get("/events/1"))
                .andDo(print())
                .andExpect(status().isOk());

        this.mockMvc.perform(get("/events/2"))
                .andDo(print())
                .andExpect(status().isOk());

        this.mockMvc.perform(get("/events/3"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getPostEvent() throws Exception {

        this.mockMvc.perform(post("/events")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getDeleteEvent() throws Exception {
        this.mockMvc.perform(delete("/events/1"))
                .andDo(print())
                .andExpect(status().isOk());

        this.mockMvc.perform(delete("/events/2"))
                .andDo(print())
                .andExpect(status().isOk());

        this.mockMvc.perform(delete("/events/3"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getPutEvent() throws Exception {
        this.mockMvc.perform(put("/events/1")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

        this.mockMvc.perform(delete("/events/2")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
