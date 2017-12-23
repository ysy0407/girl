package com.ysy.girl.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void girlList() throws Exception {
        //url为该方法的url，并不加上项目名称及ip地址，端口号等
        //get(String url)表示使用get方法进行请求 andExpect期望
        //MockMvcResultMatchers.status().is(200) || isOK() 返回的状态码是200
        //MockMvcResultMatchers.content().string(“aaa”) 返回的内容是“aaa”
        mvc.perform(MockMvcRequestBuilders.get("/getGirls"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("asd"));
    }

    @Test
    public void findByAge() throws Exception {
    }

    @Test
    public void addGirl01() throws Exception {
    }

    @Test
    public void addGirl02() throws Exception {
    }

    @Test
    public void getGirl() throws Exception {
    }

    @Test
    public void delGirl() throws Exception {
    }

    @Test
    public void updateGirl() throws Exception {
    }

    @Test
    public void addGirls() throws Exception {
    }

    @Test
    public void getAge() throws Exception {
    }

}