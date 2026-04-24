package com.ankitrajlogin.jobportal.company.controller;


import com.ankitrajlogin.jobportal.dto.CompanyDto;
import com.ankitrajlogin.jobportal.company.service.ICompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final ICompanyService companyService ;

//---------------------------------------------------
//    @Autowired // optional
//    public CompanyController(ICompanyService companyService){  // -> not needed @RequiredARgsConstutor do this with all final value ;
//        this.companyService = companyService ;
//    }
//---------------------------------------------------------

    @GetMapping(version="1.0")
    public ResponseEntity<List<CompanyDto>>getAllCompanies(){

//        throw new NullPointerException("Throwing null pointer exception") ;
//        throw new RuntimeException("this is the basic exception") ;

        System.out.println("This is for the version basic");
        List<CompanyDto> companyList = companyService.getAllCompanies() ;
        return ResponseEntity.ok().body(companyList) ;
    }

    @GetMapping(version="2.0")
    public ResponseEntity<String>getAllCompaniesVersion2(){
        return ResponseEntity.ok().body("Returning the Companies List from the version2") ;
    }

}
