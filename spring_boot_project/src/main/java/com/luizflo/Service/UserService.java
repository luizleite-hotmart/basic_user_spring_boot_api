package com.luizflo.Service;

import com.luizflo.Entity.User;
import com.luizflo.Repository.UserRepository;
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
}
