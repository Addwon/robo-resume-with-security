package com.week4challange.roboresumewithsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... strings) throws Exception{
       System.out.println("Loading data . . .");
       //roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));

        Role adminRole=roleRepository.findByRole("ADMIN");
        //Role userRole=roleRepository.findByRole("USER");

        User user=new User("admin@admin.com","beastmaster","Dave","Wolf",true,"DaveWolf","Employer");
        user.setRoles(Arrays.asList(adminRole));
        userRepository.save(user);

        roleRepository.save(new Role("APPLICANT"));
        Role applicantRole=roleRepository.findByRole("APPLICANT");
        user=new User("applicant@applicant.com","applicant","Applicant","User",true,"applicant","");
        user.setRoles(Arrays.asList(applicantRole));
        userRepository.save(user);

        roleRepository.save(new Role("EMPLOYER"));
        Role employerRole=roleRepository.findByRole("EMPLOYER");
        user=new User("employer@employer.com","employer","Employer","User",true,"employer","");
        user.setRoles(Arrays.asList(employerRole));
        userRepository.save(user);
    }
}
