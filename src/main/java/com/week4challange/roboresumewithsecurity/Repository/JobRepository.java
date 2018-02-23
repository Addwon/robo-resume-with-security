package com.week4challange.roboresumewithsecurity.Repository;

import com.week4challange.roboresumewithsecurity.Model.Job;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface JobRepository extends CrudRepository<Job,Long> {

    Iterable<Job> findAllByRequiredSkillContainingIgnoreCase(String requiredskill);
Set<Job> findByJobTitle(String jobtitle);

}
