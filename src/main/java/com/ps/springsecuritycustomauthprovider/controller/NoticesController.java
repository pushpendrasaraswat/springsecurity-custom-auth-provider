package com.ps.springsecuritycustomauthprovider.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ps.springsecuritycustomauthprovider.model.Notice;
import com.ps.springsecuritycustomauthprovider.repository.NoticeRepository;

@RestController
public class NoticesController {

    @Autowired
    private NoticeRepository noticeRepository;

    @GetMapping("/notices")
    public ResponseEntity<Iterable<Notice>> getNotices() {
        Iterable<Notice> notices = noticeRepository.findAll();
        if (notices != null) {
            return ResponseEntity.ok().cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS)).body(notices);
        } else {
            return null;
        }
    }

}
