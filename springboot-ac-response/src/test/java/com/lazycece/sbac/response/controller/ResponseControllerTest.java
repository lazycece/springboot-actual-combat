package com.lazycece.sbac.response.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

/**
 * @author lazycece
 * @date 2019/02/22
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class ResponseControllerTest {

    @Resource
    private MockMvc mockMvc;

    @Test
    public void testGetDataJson() throws Exception {
        MvcResult response = this.mockMvc
                .perform(MockMvcRequestBuilders.get("/response/data/user/info"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        System.out.println(response.getResponse().getContentAsString());
    }

    @Test
    public void testGetMapJson() throws Exception {
        MvcResult response = this.mockMvc
                .perform(MockMvcRequestBuilders.get("/response/map/user/info"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        System.out.println(response.getResponse().getContentAsString());
    }
}
