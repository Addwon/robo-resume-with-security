package com.week4challange.roboresumewithsecurity.Repository;

import com.week4challange.roboresumewithsecurity.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    User findById(long id);
    Long countByEmail(String email);
    Long countByUsername(String username);
    User findDistinctByRoles(String role);
//    User findByUsertype(String usertype);
}
