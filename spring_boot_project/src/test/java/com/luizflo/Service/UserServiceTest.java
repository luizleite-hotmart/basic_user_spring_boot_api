package com.luizflo.Service;

import com.luizflo.Entity.User;
import com.luizflo.Repository.UserRepository;
import com.luizflo.Vo.UserVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static com.luizflo.testEntity.UserBuilder.user;

/**
 * Created by luizleite on 05/08/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void updateUser() throws Exception {
        User user = user()
                .withEmail("xp.luiz@gmail.com")
                .withName("luiz oliveira")
                .withPassword("fdsjali")
                .build();
        BDDMockito.given(userRepository.findOne(Matchers.anyLong())).willReturn(user);
        userService.updateUser(createUserVO());
    }

    @Test
    public void deleteUser() throws Exception {
        User user = user()
                .withEmail("xp.luiz@gmail.com")
                .withName("luiz oliveira")
                .withPassword("fdsjali")
                .build();
        BDDMockito.given(userRepository.findOne(Matchers.anyLong())).willReturn(user);
        userService.deleteUser(1l);
        Assert.assertFalse(user.getActive());
    }

    private static UserVO createUserVO() {
        UserVO userVO =  new UserVO();
        userVO.setEmail("xp.luiz@gmail.com");
        return userVO;
    }

}