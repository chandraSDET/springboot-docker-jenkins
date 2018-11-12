package com.sdet.SpringBootLearning.Service;

import com.sdet.SpringBootLearning.model.User;
import com.sdet.SpringBootLearning.repository.UserRepository;
import com.sdet.SpringBootLearning.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void saveUserTest(){
        User user = new User();
        user.setFirstName("k");
        user.setSecondName("n");
        user.setEmail("kn@gmail.com");
        when(userService.saveUser(any(User.class))).thenReturn(user);
        User newUser = userService.saveUser(user);
        Assert.assertEquals("k",newUser.getFirstName());
    }

    @Test
    public void getUserById(){
        User user = new User();
        user.setFirstName("k");
        user.setSecondName("n");
        user.setEmail("kn@gmail.com");
        when(userService.getUserById(any(Long.class))).thenReturn(user);
        User newUser = userService.getUserById(1);
        Assert.assertEquals("k",newUser.getFirstName());
    }

    @Test
    public void getAllUsers(){
        User user = new User();
        user.setFirstName("k");
        user.setSecondName("n");
        user.setEmail("kn@gmail.com");
        List<User> list = new ArrayList<User>();
        list.add(user);
        when(userService.getAllUsers()).thenReturn(list);
        List<User> newUsers = userService.getAllUsers();
        Assert.assertEquals("k",newUsers.get(0).getFirstName());
    }

}
