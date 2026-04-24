package com.ankitrajlogin.backend.dto;


// A record is a special type of class used to store immutable data with less boilerplate code.
// JSON → converted to UserDto
public record UserDto(String name, String email, String gender, String age){


    public String getDisplayName(){
        return name + " (" + gender + ")" ;
    }

}


/*
| Feature     | Record    | Class          |
        | ----------- | --------- | -------------- |
        | Boilerplate | ❌ Minimal | ❌ High         |
        | Mutable     | ❌ No      | ✅ Yes          |
        | Use case    | DTO       | Business logic |
        | Getters     | name()    | getName()      |


 */
