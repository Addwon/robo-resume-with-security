package com.week4challange.roboresumewithsecurity.Repository;

import com.week4challange.roboresumewithsecurity.Model.Experience;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ExperienceRepository extends CrudRepository<Experience,Long>{
//    Set<Experience> findById(long id);
    Experience findById(long id);
    Experience findByCompany(String company);
}
