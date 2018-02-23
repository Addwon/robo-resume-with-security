package com.week4challange.roboresumewithsecurity.DataLoader;

import com.week4challange.roboresumewithsecurity.Model.*;
import com.week4challange.roboresumewithsecurity.Repository.*;
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

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    SkillRepository skillRepository;

    @Override
    public void run(String... strings) throws Exception{
        System.out.println("Loading data . . .");
        //roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));

        Role adminRole=roleRepository.findByRole("ADMIN");
        //Role userRole=roleRepository.findByRole("USER");

        User user=new User("admin@admin.com","beastmaster","Dave","Wolf",true,"DaveWolf","");
        user.setRoles(Arrays.asList(adminRole));
        userRepository.save(user);

        roleRepository.save(new Role("APPLICANT"));
        Role applicantRole=roleRepository.findByRole("APPLICANT");
        user=new User("jjjschmidt@gmail.com","applicant","John","Jingleheimer-Schmidt",true,"applicant","https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50");
        user.setRoles(Arrays.asList(applicantRole));
        userRepository.save(user);

        roleRepository.save(new Role("EMPLOYER"));
        Role employerRole=roleRepository.findByRole("EMPLOYER");
        user=new User("employer@employer.com","employer","Employer","User",true,"employer","");
        user.setRoles(Arrays.asList(employerRole));
        userRepository.save(user);

        roleRepository.save(new Role("RECRUITER"));
        Role recruiterRole=roleRepository.findByRole("RECRUITER");
        user=new User("recruiter@recruiter.com","recruiter","Recruiter","User",true,"recruiter","");
        user.setRoles(Arrays.asList(recruiterRole));
        userRepository.save(user);
/*
        Skill skillType=skillRepository.findByType("Java");
        user=new User("jjjschmidt@gmail.com","applicant","John","Jingleheimer-Schmidt",true,"applicant","https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50");
        user.setSkills(Arrays.asList(skillType));
        userRepository.save(user);
        */
//        UserData user1=new UserData();
//        user1.setFirstName("John");
//        user1.setLastName("Jingleheimer-Schmidt");
//        user1.setEmail("jjjschmidt@gmail.com");
//        userDataRepository.save(user1);

        Education education=new Education();
        education.setMajor("BS in Psychology");
        education.setSchool("UMaryland");
        education.setGradYear(2002);
        educationRepository.save(education);

        Experience experience=new Experience();
        experience.setJobPosition("Software Developer II");
        experience.setCompany("Amtrak");
        experience.setDuration("2015-Present");
        experience.setDuties("programming and database dev't");
        experienceRepository.save(experience);

        Skill skill1=new Skill();
        skill1.setType("Java");
        skill1.setSkillLevel("Highly skilled");
        skillRepository.save(skill1);

        Skill skill2=new Skill();
        skill2.setType("PHP");
        skill2.setSkillLevel("skilled");
        skillRepository.save(skill2);


        Organization orgn1=new Organization();
        orgn1.setOrganizationName("Montgomery College");
        orgn1.setOrganizationAddress("12 Summit street Getsburg");
        //orgn1.setJobs(null);
        organizationRepository.save(orgn1);

        Organization orgn2=new Organization();
        orgn2.setOrganizationName("XYZ Company");
        orgn2.setOrganizationAddress("5929 Georgia Ave");
        //orgn2.setJobs(null);
        organizationRepository.save(orgn2);


        Job job1=new Job();
        job1.setJobTitle("Software Programmer");
        job1.setJobDescription("Developing application software for small scale businesses");
        job1.setRequiredSkill(skill1.getType()+","+skill1.getSkillLevel());
        job1.setRequiredExperience("2 years");
//        job1.setOrganizations(orgn1.getOrganizationName());
        job1.set_orgnization(orgn1.getOrganizationName()+" "+orgn1.getOrganizationAddress());
        jobRepository.save(job1);

        Job job2=new Job();
        job2.setJobTitle("Web Developer");
        job2.setJobDescription("Web development");
        //job2.setRequiredSkill("PHP");
        job2.setRequiredSkill(skill2.getType()+","+skill2.getSkillLevel());
        job2.setRequiredExperience("3 years");
        job2.set_orgnization(orgn2.getOrganizationName()+" "+orgn2.getOrganizationAddress());
        jobRepository.save(job2);

    }
}