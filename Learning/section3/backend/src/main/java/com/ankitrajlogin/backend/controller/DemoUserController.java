package com.ankitrajlogin.backend.controller;


import com.ankitrajlogin.backend.dto.UserDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/api/dummy/users")
public class DemoUserController {


//    server.servlet.context-path=/backend
//    http://localhost:8081/backend/api/dummy/users/1/posts/100 ( to get the request) =>
//    response => fetched user with id:1and post id:100

    @GetMapping({"/{userId}/posts/{postId}" , "/api/dummy/users/{userId}"})
    public String searchUsrPostWithMultiPathVariables(@PathVariable Long userId , @PathVariable(required = false) Long postId){

        if(postId == null){
            return "fetched all post with user id:" + userId ;
        }
        return "fetched user with id:" + userId + "and post id:" + postId ;
    }

    @GetMapping({"/{userId}/order/{orderId}"})
    public String searchUsrOrderWithcustomerIdVariable(@PathVariable(name="userId") Long customerId , @PathVariable Long orderId){
        return "fetched customer with id:" + customerId + "and order id:" + orderId;
    }


    // Query Params
    @GetMapping("/search")
    public String searchUserWithQueryParams(@RequestParam(required = false,defaultValue = "Guest") String name, @RequestParam(name="gender") String sex){
        return "Fetched user with query params: " + name + " and gender: " + sex ;
    }

    // Query Params map
    @GetMapping("/search/map")
    public String searchUserWithMapQueryParams(@RequestParam Map<String,String> params){
        String age = params.get("age");
        String city = params.get("city");
        String role = params.get("role");
        String status = params.get("status");
        String gender = params.get("gender") ;

        // getting value or set default value
        params.getOrDefault("name", "guest");

        // here unavailable value become null :
        System.out.println("printing value of  city: " + city) ;
        return params.toString() ;
    }

    @GetMapping("/headers")
    public String readRequestHeaders(@RequestHeader("User-Agent") String userAgent, @RequestHeader(name="User-location", required = false, defaultValue = "India") String userLocation){
        return "Fetched user with headers Received=> User-Agent: " + userAgent + ", User-location: " + userLocation ;
    }

    @GetMapping("/headers/map")
    public String getUsers(@RequestHeader Map<String, String> headers) {

        String authorization = headers.getOrDefault("authorization", "No Token");
        String tag = headers.get("X-Tag");

        return headers.toString() + ", authorization: " + authorization + ", tags: " + tag ;
    }

    // we if want to handle multi-values support

    @GetMapping("/headers/map/multivalue")
    public String test(@RequestHeader HttpHeaders headers) {

        List<String> tags = headers.get("X-Tag");

        String first = tags.get(0) ;
        String second = tags.get(1) ;
        String third ;

        // similarly first and second value ;
        if(tags != null && tags.size() > 2){
            third = tags.get(2) ;
        }
        else{
            third = "empty" ;
        }

        System.out.println("first : " + first + ", second: " + second + ", third: " + third);

        if (tags != null) {
            return headers.toString() + " \n" + tags.toString();
        }

        return headers.toString() + " \n" + "No tags";
    }

    @PostMapping("/create")
    public String createUser(@RequestBody UserDto userDto){
        return "Created User with the data: " + userDto.toString() ;
    }

    @PostMapping("request-entity")
    public String createUserWithRequestEntity(RequestEntity<UserDto> requestEntity){
        HttpHeaders httpHeaders = requestEntity.getHeaders() ;
        UserDto userDto = requestEntity.getBody() ;
        String queryParam = requestEntity.getUrl().getQuery() ;
        String pathVariables = requestEntity.getUrl().getPath() ;


        // get specific value :
        String userAgent = httpHeaders.getFirst("User-Agent");
        String contentType = httpHeaders.getFirst("Content-Type");

        // if multiple values ;
        List<String> encodings = httpHeaders.get("X-tag");
        String first = encodings.get(0) ;
        String second = encodings.get(1) ;

        System.out.println("getting x-tag value => " + "first: " + first + ", second: " + second) ;


        // Getting body ;
        String name = userDto.name() ;
        String email = userDto.email() ;
        String gender = userDto.gender() ;

        System.out.println("getting body => " + "name: " + name + ", email: " + email + ", gender: " +gender);


        // getting query Params

        String[] params = queryParam.split("&") ;

        String db = null ;
        String part = null ;
        for(String param : params){
            String[] pair = param.split("=") ;
            if (pair[0].equals("db")) {
                db = pair[1];
            }
            if (pair[0].equals("part")) {
                part = pair[1];
            }
        }

        System.out.println("getting params => " + "db: " + db + ", part: " + part );




        return "header: " + httpHeaders + "\n"
                + "Body: " + userDto + "\n"
                + "queryParams: " + queryParam + "\n"
                + "pathVariable: " + pathVariables ;
    }



    // ResponseEntity
    @GetMapping("/okresponse")
    public ResponseEntity<String> sendingOkReponse(){
        String response = "If we want to consume send the reponse ok (200). then need to set return type is responseEntity<Datatype>" ;

        return ResponseEntity.ok(response) ;
    }


    @PostMapping("/createUser")
    public ResponseEntity<UserDto> createUser(){
        UserDto user = new UserDto("Ankit" , "ankitrajlogin@gmail.com" , "male" , "23") ;

        HttpHeaders headers = new HttpHeaders() ;
        headers.add("X-App" , "Backend") ;
        headers.add("X-Source" , "SpringBoot") ;

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .headers(headers)
                .body(user) ;

    }










}
