package com.hansol.springmvc.request.mapping;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
@RunWith(SpringRunner.class)
@WebMvcTest(ExtendRequestMapping.class)
public class ExtendSimpleControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void helloTest() throws Exception {
        this.mockMvc.perform(get("/hello/hansol"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello hansol"))
                .andExpect(handler().handlerType(ExtendRequestMapping.class))
                .andExpect(handler().methodName("hello"));

    }
}
