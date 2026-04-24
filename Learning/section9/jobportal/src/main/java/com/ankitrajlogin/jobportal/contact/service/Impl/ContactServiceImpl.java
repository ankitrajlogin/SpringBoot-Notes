package com.ankitrajlogin.jobportal.contact.service.Impl;

import com.ankitrajlogin.jobportal.company.service.ICompanyService;
import com.ankitrajlogin.jobportal.contact.service.IContactService;
import com.ankitrajlogin.jobportal.dto.CompanyDto;
import com.ankitrajlogin.jobportal.dto.ContactRequestDto;
import com.ankitrajlogin.jobportal.entity.Contact;
import com.ankitrajlogin.jobportal.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements IContactService {

    private final ContactRepository contactRepository;

    @Override
    public boolean saveContact(ContactRequestDto contactRequestDto) {
        boolean result = false;
        Contact contact = contactRepository.save(transformToEntity(contactRequestDto));
        if(contact != null && contact.getId() != null) {
            result = true;
        }
        return result;
    }

    private Contact transformToEntity(ContactRequestDto contactRequestDto) {
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactRequestDto, contact);
//        contact.setCreatedAt(Instant.now());
//        contact.setCreatedBy("System");
        contact.setStatus("NEW");
        return contact;
    }
}