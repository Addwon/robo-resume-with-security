package com.week4challange.roboresumewithsecurity;

import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job,Long> {

    Iterable<Job> findAllByRequiredSkillContainingIgnoreCase(String availability);

}
