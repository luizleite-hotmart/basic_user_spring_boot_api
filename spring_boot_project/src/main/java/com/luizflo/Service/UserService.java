package com.luizflo.Service;

import com.luizflo.Entity.User;
import com.luizflo.Repository.UserRepository;
import com.luizflo.Vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired(required = true)
    private UserRepository userRepository;

    public User findUserById(Long id) {
        return userRepository.findOne(id);
    }

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public void createUser(UserVo userVo) {
        User user = new User(userVo.getEmail(), userVo.getName());
        user.setPassword(userVo.getPassword());
        userRepository.save(user);
    }

}
