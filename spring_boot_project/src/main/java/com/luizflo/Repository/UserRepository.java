package com.luizflo.Repository;

import com.luizflo.Entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    List<User> findByName(String name);

    User findUserByEmail(String email);

}
