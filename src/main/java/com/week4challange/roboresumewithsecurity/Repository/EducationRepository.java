package com.week4challange.roboresumewithsecurity.Repository;

import com.week4challange.roboresumewithsecurity.Model.Education;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface EducationRepository extends CrudRepository<Education,Long> {
    //Education findByMajor(String major);
    Education findById(long id);
//    Set<Education> findById(long id);
}
