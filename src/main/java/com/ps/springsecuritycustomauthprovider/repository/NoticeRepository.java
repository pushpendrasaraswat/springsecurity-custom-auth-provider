package com.ps.springsecuritycustomauthprovider.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ps.springsecuritycustomauthprovider.model.Notice;


@Repository
public interface NoticeRepository extends CrudRepository<Notice, Long> {

}
