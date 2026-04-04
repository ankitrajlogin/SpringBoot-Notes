package com.ankitrajlogin.backend.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/home")
    public String sayHello(){
        return "Hello World" ;
    }

//    http://localhost:8081/backend/api/dummy/users/1/posts/100 ( to get the request) =>
//    response => fetched user with id:1and post id:100
    @GetMapping("/api/dummy/users/{userId}/posts/{postId}")
    public String searchUsrPostWithMultiPathVariables(@PathVariable Long userId , @PathVariable Long postId){
        return "fetched user with id:" + userId + "and post id:" + postId ;
    }




}
