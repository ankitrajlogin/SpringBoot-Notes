package com.ankitrajlogin.jobportal.scopes;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/scope")
@RequiredArgsConstructor
public class ScopeController {

    private final RequestScopedBean requestScopedBean;
    private final SessionScopedBean sessionScopedBean;
    private final ApplicationScopedBean applicationScopedBean;

    @GetMapping("/request")
    public ResponseEntity<String> RequestScope() {
        requestScopedBean.setUsername("John Doe");
        return ResponseEntity.ok().body(requestScopedBean.getUsername());
    }

    @GetMapping("/testRequest")
    public ResponseEntity<String> testRequestScope(){
        return ResponseEntity.ok().body(requestScopedBean.getUsername()) ;
    }

    @GetMapping("/session")
    public ResponseEntity<String> SessionScope() {
        sessionScopedBean.setUsername("John Doe");
        return ResponseEntity.ok().body(sessionScopedBean.getUsername());
    }

    @GetMapping("/testSession")
    public ResponseEntity<String> testSessionScope(){
        return ResponseEntity.ok().body(sessionScopedBean.getUsername()) ;
    }

    @GetMapping("/application")
    public ResponseEntity<Integer> ApplicationScope() {
        applicationScopedBean.incrementVistorsCount();
        return ResponseEntity.ok().body(applicationScopedBean.getVistorsCount());
    }



    @GetMapping("/testApplication")
    public ResponseEntity<Integer> testScopeApplication() {
        return ResponseEntity.ok().body(applicationScopedBean.getVistorsCount());
    }

}