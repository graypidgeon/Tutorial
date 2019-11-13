package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void init() {
        User returnUser = new User();
        returnUser.setId(1l);
        returnUser.setEmail("asd");
        returnUser.setName("www");
        given(userRepository.findById(1l)).willReturn(Optional.of(returnUser));

        List<User> users = new ArrayList<User>();
        users.add(returnUser);
        given(userRepository.findAll()).willReturn(users);
    }

    @Test
    public void testShowSignUpForm() throws Exception {
        mockMvc.perform(get("/signup"))
                .andExpect(status().isOk())
                .andExpect(view().name("add-user"))
                .andExpect(content().string(containsString("add-user")));
    }

    @Test
    public void testShowAddUserForm() throws Exception {
        mockMvc.perform(post("/add-user")
                .param("name", "ok")
                .param("email", "ok"))
//                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("all-users"))
                .andExpect(content().string(containsString("edit-user")))
                .andExpect(content().string(containsString("delete-user")));
    }

    @Test
    public void testShowAddUserFormWithErrors() throws Exception {
        mockMvc.perform(post("/add-user"))
//                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("add-user"))
                .andExpect(content().string(containsString("Name is mandatory")))
                .andExpect(content().string(containsString("Email is mandatory")));
    }

    @Test
    public void testGetEditUserNotFound() throws Exception {
        mockMvc.perform(get("/edit-user"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetEditUser() throws Exception {
        mockMvc.perform(get("/edit-user/1"))
//                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("edit-user"))
                .andExpect(content().string(containsString("asd")));
    }

    @Test
    public void testPostEditUserWithErrors() throws Exception {
        mockMvc.perform(post("/edit-user/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("edit-user"))
                .andExpect(content().string(containsString("Name is mandatory")))
                .andExpect(content().string(containsString("Email is mandatory")));
    }

    @Test
    public void testPostEditUser() throws Exception {
        mockMvc.perform(post("/edit-user/1")
                .param("name", "ok")
                .param("email", "ok"))
                .andExpect(status().isOk())
                .andExpect(view().name("all-users"));
    }

    @Test
    public void testDeleteUser() throws Exception {
        mockMvc.perform(get("/delete-user/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("all-users"));
    }

    //TODO some kind of exception resolver?
    @Test
    public void testDeleteUserError() throws Exception {
        mockMvc.perform(get("/delete-user/2"))
                .andExpect(status().isOk())
                .andExpect(view().name("all-users"));
    }
}
