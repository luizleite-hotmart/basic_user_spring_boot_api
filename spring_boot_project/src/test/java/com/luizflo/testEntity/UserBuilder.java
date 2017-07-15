package com.luizflo.testEntity;

import com.luizflo.Entity.User;

/**
 * Created by luizoliveira on 15/07/17.
 */
public class UserBuilder {

    private final User user;
    private UserBuilder() {
        user = new User();
    }

    public User buildSomeUser() {
        User user = new User("email@email.com", "name so cool");
        return user;
    }


}
