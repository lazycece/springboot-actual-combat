package com.lazycece.sbac.validation.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.annotation.Resource;

/**
 * @author lazycece
 * @date 2019/02/15
 */
@WebMvcTest
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Resource
    private MockMvc mockMvc;

    @Test
    public void testAddUserInfo() throws Exception {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", "lazycece");
        params.add("age", "201");
        params.add("sex", "2");
        params.add("role", "3");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/user/add")
                        .params(params))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testUpdateUserInfo() throws Exception {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("id", "1");
        params.add("username", "lazycece");
        params.add("age", "200");
        params.add("sex", "2");
        params.add("role", "3");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/user/update")
                        .params(params))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testQueryUserInfo() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/user/query")
                        .param("username", "lazycece"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
