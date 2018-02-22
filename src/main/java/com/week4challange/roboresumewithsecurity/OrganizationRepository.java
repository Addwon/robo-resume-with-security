package com.week4challange.roboresumewithsecurity;

import org.springframework.data.repository.CrudRepository;

public interface OrganizationRepository extends CrudRepository<Organization,Long>{
    Organization findByOrganizationName(String organizationName);
}
