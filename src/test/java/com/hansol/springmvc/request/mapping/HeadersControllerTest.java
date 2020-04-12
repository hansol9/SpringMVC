package com.hansol.springmvc.request.mapping;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HeadersController.class)
public class HeadersControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void headerTest() throws Exception {

        this.mockMvc.perform(get("/hello")
//                .header(HttpHeaders.FROM, "localhost"))
                .header(HttpHeaders.AUTHORIZATION, "111"))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    @Test
    public void paramTest() throws Exception {

        this.mockMvc.perform(get("/header")
                .param("name", "hansol"))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }



}