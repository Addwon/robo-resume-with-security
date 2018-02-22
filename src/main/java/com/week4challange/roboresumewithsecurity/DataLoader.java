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

    @Autowired
    JobRepository jobRepository;

    @Autowired
    OrganizationRepository organizationRepository;

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


        Organization orgn1=new Organization();
        orgn1.setOrganizationName("Montgomery College");
        orgn1.setOrganizationAddress("12 Summit street Getsburg");
        organizationRepository.save(orgn1);

        Organization orgn2=new Organization();
        orgn2.setOrganizationName("XYZ Company");
        orgn2.setOrganizationAddress("5929 Georgia Ave");
        organizationRepository.save(orgn2);

        Job job1=new Job();
        job1.setJobTitle("Software Programmer");
        job1.setJobDescription("Developing application software for small scale businesses");
        job1.setRequiredSkill("java");
        job1.setRequiredExperience("2 years");
        jobRepository.save(job1);

        Job job2=new Job();
        job2.setJobTitle("Software Programmer");
        job2.setJobDescription("Web development");
        job2.setRequiredSkill("PHP");
        job2.setRequiredExperience("3 years");
        jobRepository.save(job2);
    }
}
