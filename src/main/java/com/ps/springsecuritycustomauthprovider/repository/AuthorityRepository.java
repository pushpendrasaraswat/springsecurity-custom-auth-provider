package com.ps.springsecuritycustomauthprovider.repository;

import com.ps.springsecuritycustomauthprovider.model.Authority;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface AuthorityRepository extends CrudRepository<Authority,Long> {

    Set<Authority> findByCustomer_Id(long id);
}
