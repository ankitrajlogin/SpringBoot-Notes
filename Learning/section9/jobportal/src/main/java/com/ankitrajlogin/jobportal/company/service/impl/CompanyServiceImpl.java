package com.ankitrajlogin.jobportal.company.service.impl;

import com.ankitrajlogin.jobportal.dto.CompanyDto;
import com.ankitrajlogin.jobportal.entity.Company;
import com.ankitrajlogin.jobportal.repository.CompanyRepository;
import com.ankitrajlogin.jobportal.company.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements ICompanyService {

    private final CompanyRepository companyRepository ;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository){
        this.companyRepository = companyRepository ;
    }



    @Override
    public List<CompanyDto> getAllCompanies(){
//        System.out.println("this is all the value of the company" + companyRepository.findAll());
        List<Company>companyList = companyRepository.findAll() ;

        return companyList.stream().map(this::transformToDto).collect(Collectors.toList()) ;
    }

    private CompanyDto transformToDto(Company company) {
        return new CompanyDto(company.getId(), company.getName(), company.getLogo(),
                company.getIndustry(), company.getSize(), company.getRating(),
                company.getLocations(), company.getFounded(), company.getDescription(),
                company.getEmployees(), company.getWebsite(), company.getCreatedAt());
    }
}
