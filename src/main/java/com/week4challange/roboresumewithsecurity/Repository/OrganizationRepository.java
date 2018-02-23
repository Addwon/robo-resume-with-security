package com.week4challange.roboresumewithsecurity.Repository;

import com.week4challange.roboresumewithsecurity.Model.Organization;
import org.springframework.data.repository.CrudRepository;

public interface OrganizationRepository extends CrudRepository<Organization,Long>{
    Organization findByOrganizationName(String organizationName);

}
