package com.luizflo.Service;

import com.luizflo.Vo.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by luizleite on 05/08/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Test
    public void createUser() throws Exception {

    }

    @Test
    public void updateUser() throws Exception {
    }

    @Test
    public void deleteUser() throws Exception {
    }

    private static UserVO createUserVO() {
        UserVO userVO =  new UserVO();
        userVO.setEmail("xp.luiz@gmail.com");
        return userVO;
    }

}