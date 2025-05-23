package com.example.tdd.controller;

import com.example.tdd.model.User;
import com.example.tdd.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @MockitoBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    List<User> users = new ArrayList<>();

    @BeforeEach
    public void setup() {
        users.add(new User(1, "Test", "test@mail.com"));
    }

    @Test
    public void testFindAllUsers() throws Exception {

        String jsonUserResponse = """
                [
                    {
                        "id":1,
                        "name":"Test",
                        "email":"test@mail.com"
                    }
                ]
                """;

        when(userService.findAllUsers()).thenReturn(users);
        ResultActions resultActions = mockMvc.perform(get("/api/findAllUsers")).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().json(jsonUserResponse));

        JSONAssert.assertEquals(jsonUserResponse, resultActions.andReturn().getResponse().getContentAsString(), false);
    }

    @Test
    public void testFindByUserId() throws Exception {

        String jsonUserResponse = """
                {
                "id": 1,
                "name": "Test",
                "email": "test@mail.com"
                }
                """;

        when(userService.findByUserId(1)).thenReturn(new User(1, "Test", "test@mail.com"));

        ResultActions resultActions = mockMvc.perform(get("/api/findById/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(jsonUserResponse));

        JSONAssert.assertEquals(jsonUserResponse, resultActions.andReturn().getResponse().getContentAsString(), false);

    }

}
