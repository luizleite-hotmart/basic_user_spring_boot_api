package com.luizflo.Controller;

import com.luizflo.Entity.User;
import com.luizflo.Service.UserService;
import com.luizflo.Vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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

    @RequestMapping(method = RequestMethod.GET, path = "/{userEmail}")
    public User findUserByEmail(@PathVariable(value = "userEmail") String userEmail) {
        return userService.findUserByEmail(userEmail);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@Valid @RequestBody UserVO userVO) {
        userService.createUser(userVO);
        return new ResponseEntity<String>("ok", HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserVO userVO) {
        userService.createUser(userVO);
        return new ResponseEntity<String>("ok", HttpStatus.CREATED);
    }
}
