package com.ps.springsecuritycustomauthprovider.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ps.springsecuritycustomauthprovider.model.Contact;


@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {


}
