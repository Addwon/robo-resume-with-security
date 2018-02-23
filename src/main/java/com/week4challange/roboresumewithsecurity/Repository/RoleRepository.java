package com.week4challange.roboresumewithsecurity.Repository;

import com.week4challange.roboresumewithsecurity.Model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Long> {
    Role findByRole(String role);
}
