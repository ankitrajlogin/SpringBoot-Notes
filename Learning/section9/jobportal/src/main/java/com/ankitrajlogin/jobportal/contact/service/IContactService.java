package com.ankitrajlogin.jobportal.contact.service;

import com.ankitrajlogin.jobportal.dto.ContactRequestDto;

public interface IContactService {

    boolean saveContact(ContactRequestDto contactRequestDto);

}