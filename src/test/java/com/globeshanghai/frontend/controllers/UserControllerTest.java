package com.globeshanghai.frontend.controllers;

/**
 * Created by stijnergeerts on 2/05/17.
 */

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.globeshanghai.backend.dom.user.User;
import com.globeshanghai.backend.repositories.UserRepository;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserControllerTest.class)
@ComponentScan("com.globeshanghai")
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class UserControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private UserRepository userRepository;

    private MockMvc mockMvc;
    private ObjectMapper mapper;

    private String testToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJPbmxpbmUgSldUIEJ1aWxkZXIiLCJpYXQiOjE0ODY" +
            "3MzE5MzgsImV4cCI6MTUxODI2NzkzOCwiYXVkIjoid3d3LmV4YW1wbGUuY29tIiwic3ViIjoidGVz" +
            "dDYifQ.X8l82QUd7sXLuqNxiTJaQZDhU9V7_4fIi3MKNxYHOQU";


    @Before
    public void setup(){
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
        this.mapper = new ObjectMapper();
    }

    @Test
    public void aTestCreateUser() throws Exception {
        User testUser = new User();
        testUser.setAuthId(JWT.decode(testToken).getSubject());
        testUser.setFirstname("Test");
        testUser.setLastname("User");
        testUser.setUsername("TestUser");

        this.mockMvc.perform(post("/api/user/createUser").content(mapper.writeValueAsString(testUser)).header("token", testToken).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("TestUser")));
    }
    @Test
    public void bTestCreateAlreadyExistingUser() throws Exception {
        User testUser = new User();
        testUser.setAuthId(JWT.decode(testToken).getSubject());
        testUser.setFirstname("Test");
        testUser.setLastname("User");
        testUser.setUsername("TestUser");

        this.mockMvc.perform(post("/api/user/createUser").header("token", testToken).content(mapper.writeValueAsString(testUser)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isConflict());
    }

    @Test
    public void cTestUpdateUser() throws Exception {
        User updateTestUser = userRepository.findUserByAuthId(JWT.decode(testToken).getSubject());
        updateTestUser.setFirstname("TestUpdated");

        System.err.println("\n" + mapper.writeValueAsString(updateTestUser) + "\n");

        this.mockMvc.perform(put("/api/user/updateUser").header("token", testToken).content(mapper.writeValueAsString(updateTestUser)).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstname", is("TestUpdated")));
    }

    @Test
    public void dTestGetUser() throws Exception {
        String authId = JWT.decode(testToken).getSubject();
        this.mockMvc.perform(get("/api/user/getUser").header("token", testToken))
                .andDo(print())
                .andExpect(jsonPath("$.authId", Matchers.is(authId)))
                .andExpect(status().isOk());
    }

    @Test
    public void eTestGetAllUsers() throws Exception {
        this.mockMvc.perform(get("/api/user/getUsers").header("token", testToken).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void fTestGetAllUsersUnauthorized() throws Exception {
        String wrongToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJKQVQiLCJpYXQiOjE0ODgyMTA5NzAsImV4cCI6MTUxOTc0Njk3MCwiYXVkIjoid3d3LmV4YW1wbGUuY29tIiwic3ViIjoiam9za2UwNDExNTEifQ.4-yVCxaRtnKe_AgcXR1jafmmcR9fQrLqF3YWGhqXerM";

        this.mockMvc.perform(get("/api/user/getUsers").header("token", wrongToken).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    public void gTestDeleteUser() throws Exception {
        this.mockMvc.perform(delete("/api/user/deleteUser").header("token", testToken).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
