package com.week4challange.roboresumewithsecurity.Repository;

import com.week4challange.roboresumewithsecurity.Model.Job;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface JobRepository extends CrudRepository<Job,Long> {

Iterable<Job> findAllByRequiredSkillContainingIgnoreCase(String requiredskill);
Iterable<Job> findAllBy_orgnizationContainingIgnoreCase(String organizationName);


    //    Iterable<Job>findAllByJobTitleContainingIgnoreCase(String jobtitle);
////Set<Job> findByJobTitle(String jobtitle);
//Job findAllByJobTitle(String jobtitle);
////Job findByOrganizationAndRequiredSkill(String search);
    Job findById(long id);
    Job findByJobTitle(String title);
}
