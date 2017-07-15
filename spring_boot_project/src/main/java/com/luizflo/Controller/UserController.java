package com.luizflo.Controller;

import com.luizflo.Entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by luizoliveira on 15/07/17.
 */

@RestController
@RequestMapping("/users")
public class UserController {

    @RequestMapping(method = RequestMethod.GET, path = "/entity")
    public User simpleTest(@RequestParam(value = "name", defaultValue = "easy") String name) {
        return new User("xp.luiz@gmail.com", name);
    }
}
