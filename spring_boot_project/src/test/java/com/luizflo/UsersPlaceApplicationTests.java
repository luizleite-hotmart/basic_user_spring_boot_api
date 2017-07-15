package com.luizflo;

import com.luizflo.Entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersPlaceApplicationTests {

    @Test
    public void firstTest() {
        User user = buildSomeUser();
        Assert.assertEquals(user.getUsername(), "name.so.cool");

    }

    private static User buildSomeUser() {
        User user = new User("email@email.com", "name so cool");
        return user;
    }


}
