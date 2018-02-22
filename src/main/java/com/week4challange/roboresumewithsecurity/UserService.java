package com.week4challange.roboresumewithsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public Long countByEmail(String email){
        return userRepository.countByEmail(email);
    }
    public User findByUsername(String username){
        return userRepository.findByEmail(username);
    }
    public User findByUsertype(String usertype){
        return userRepository.findByUsertype(usertype);
    }
    public void saveUser(User user){
        user.setRoles(Arrays.asList(roleRepository.findByRole("USER")));
        user.setEnabled(true);
        userRepository.save(user);
    }
    public void saveAdmin(User user){
        user.setRoles(Arrays.asList(roleRepository.findByRole("ADMIN")));
        user.setEnabled(true);
        userRepository.save(user);
    }
    public void saveApplicant(User user){
        user.setRoles(Arrays.asList(roleRepository.findByRole("APPLICANT")));
        user.setEnabled(true);
        userRepository.save(user);
    }
    public void saveEmployer(User user){
        user.setRoles(Arrays.asList(roleRepository.findByRole("EMPLOYER")));
        user.setEnabled(true);
        userRepository.save(user);
    }
    public void saveRecruiter(User user){
        user.setRoles(Arrays.asList(roleRepository.findByRole("RECRUITER")));
        user.setEnabled(true);
        userRepository.save(user);
    }
}
