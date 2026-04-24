package com.ankitrajlogin.jobportal.company.service;

import com.ankitrajlogin.jobportal.dto.CompanyDto;
import com.ankitrajlogin.jobportal.dto.ContactRequestDto;
import com.ankitrajlogin.jobportal.entity.Company;

import java.util.List;

// I represent it is a interface

public interface ICompanyService {

    List<CompanyDto> getAllCompanies() ;
}
