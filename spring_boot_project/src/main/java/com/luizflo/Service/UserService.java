package com.luizflo.Service;

import com.luizflo.Entity.Role;
import com.luizflo.Entity.User;
import com.luizflo.Repository.RoleRepository;
import com.luizflo.Repository.UserRepository;
import com.luizflo.Vo.UserVO;
import com.luizflo.security.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserService implements UserDetailsService{

    @Autowired(required = true)
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public User findUserById(Long id) {
        return userRepository.findOne(id);
    }

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public void createUser(UserVO userVO) {
        User user = new User(userVO.getEmail(), userVO.getName());
        user.setPassword(userVO.getPassword());
        userRepository.save(user);
    }

    public void updateUser(UserVO userVO) {
        User user = userRepository.findOne(userVO.getId());
        user.setName(userVO.getName());
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        User user = userRepository.findOne(userId);
        user.setActive(false);
        userRepository.save(user);
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getActive(), true, true, true, authorities);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(userName);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", userName));
        } else {
            return JwtUserFactory.create(user);
        }
    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (Role role : userRoles) {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(roles);
        return grantedAuthorities;
    }
}
