package com.week4challange.roboresumewithsecurity.Repository;

import com.week4challange.roboresumewithsecurity.Model.Skill;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface SkillRepository extends CrudRepository<Skill,Long>{
//    Skill findByType(String skill);
   //Iterable<Skill> findAllByTypeContainingIgnoreCase(String type);
//   Set<Skill> findByType(String skilltype);
//   Set<Skill> findById(long id);
   Skill findById(long id);
   Skill findByType(String type);
}
