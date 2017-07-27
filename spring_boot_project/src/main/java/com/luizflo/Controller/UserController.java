package com.luizflo.Controller;

import com.luizflo.Entity.User;
import com.luizflo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * Created by luizoliveira on 15/07/17.
 */

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, path = "/entity")
    public User returnUserModel(@RequestParam(value = "name", defaultValue = "easy") String name) {
        return new User("xp.luiz@gmail.com", name);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{userId}")
    public User findUserById(@PathVariable(value = "userId") Long userId) {
        return userService.findUserById(userId);
    }
}
