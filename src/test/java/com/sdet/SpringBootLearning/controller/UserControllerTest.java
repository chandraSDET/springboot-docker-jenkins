package com.sdet.SpringBootLearning.controller;

import com.sdet.SpringBootLearning.model.User;
import com.sdet.SpringBootLearning.service.UserService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createUserTest() throws Exception {
        User user = new User();
        user.setFirstName("c");
        user.setSecondName("k");
        user.setEmail("cg@gmail.com");
        when(userController.createUser(any(User.class)))
                .thenReturn(user);
        String sampleUserJson= "{\"firstName\":\"cs\",\"secondName\":\"nk\",\"email\":\"csnk@gmail.com\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user").accept(MediaType.APPLICATION_JSON)
                .content(sampleUserJson).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.firstName",Matchers.is("c")))
                .andExpect(jsonPath("$.secondName",Matchers.is("k")))
                .andExpect(jsonPath("$.email",Matchers.is("cg@gmail.com")));
    }

    @Test
    public void getUserByIdTest() throws Exception {
        User user = new User();
        user.setFirstName("c");
        user.setSecondName("k");
        user.setEmail("cg@gmail.com");
        when(userController.getUserById(1)).thenReturn(user);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/user/1").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.firstName",Matchers.is("c")))
                .andExpect(jsonPath("$.secondName",Matchers.is("k")))
                .andExpect(jsonPath("$.email",Matchers.is("cg@gmail.com")));
    }

    @Test
    public void getAllUsersTest() throws Exception {
        List<User> allUsers = new ArrayList<User>();
        User firstUser = new User();
        firstUser.setFirstName("c");
        firstUser.setSecondName("k");
        firstUser.setEmail("cg@gmail.com");
        allUsers.add(firstUser);
        when(userController.getAllUsers()).thenReturn(allUsers);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$[0].firstName",Matchers.is("c")))
                .andExpect(jsonPath("$[0].secondName",Matchers.is("k")))
                .andExpect(jsonPath("$[0].email",Matchers.is("cg@gmail.com")));
    }



}
