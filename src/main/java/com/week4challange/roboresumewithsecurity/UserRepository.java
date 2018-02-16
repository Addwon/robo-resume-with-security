package com.week4challange.roboresumewithsecurity;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    Long countByEmail(String email);
    Long countByUsername(String username);
    User findByUsertype(String usertype);
}
