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

    @Test
    public void ucodeMustBeDifferentForEachUser() {
        User user = buildSomeUser();
        User user2 = buildSomeUser();
        user2.setEmail("teste@newemail.com");
        Assert.assertNotEquals(user.getUcode(), user2.getUcode());
    }
}
