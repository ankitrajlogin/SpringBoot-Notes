package com.ankitrajlogin.jobportal.repository;

import com.ankitrajlogin.jobportal.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}