package com.lazycece.sbac.exception.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

/**
 * @author lazycece
 * @date 2019/02/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Resource
    private MockMvc mockMvc;

    @Test
    public void testAddUserInfo() throws Exception {
        // 测验 validation 异常处理
        MvcResult response = this.mockMvc
                .perform(MockMvcRequestBuilders.put("/user/add"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        System.out.println(response.getResponse().getContentAsString());
    }

    @Test
    public void testQueryUserInfo() throws Exception {
        // 测验自定义异常处理 -> 不穿參數
        MvcResult response = this.mockMvc
                .perform(MockMvcRequestBuilders.get("/user/info"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        System.out.println(response.getResponse().getContentAsString());
    }

    @Test
    public void testInnerError() throws Exception {
        // 测验未知异常处理 -> 不穿參數
        MvcResult response = this.mockMvc
                .perform(MockMvcRequestBuilders.get("/user/inner/error"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        System.out.println(response.getResponse().getContentAsString());
    }
}
