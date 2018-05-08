package com.greenfox.hulispring.controllers;

import static org.junit.Assert.*;

import com.greenfox.hulispring.HulispringApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.nio.charset.Charset;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyFloat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HulispringApplication.class)
@WebAppConfiguration
@EnableWebMvc
@AutoConfigureMockMvc

public class RestControllerTest {

  private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
          MediaType.APPLICATION_JSON.getSubtype(),
          Charset.forName("utf8"));

  @Autowired
  private MockMvc mockMvc;


  @Autowired
  private WebApplicationContext webApplicationContext;

  @Test
  public void jsonResponseTest() throws Exception {
    mockMvc
            .perform(get("/hello")
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.messages[1].text").value("Hello Laci"));
  }

  @Test
  public void databaseConnectionTest() throws Exception {
    mockMvc
            .perform(get("/hello"))
            .andExpect(status().isOk())
            .andExpect(status().is2xxSuccessful());
  }
}