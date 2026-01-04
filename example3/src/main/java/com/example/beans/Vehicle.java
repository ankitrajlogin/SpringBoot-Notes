package com.example.beans;

import org.springframework.stereotype.Component;

@Component
public class Vehicle {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printHello(){
        System.out.println("Printing Hello From Component Vehicle Bean") ;
    }
}


/*
@Component is a Spring annotation that marks a class as a Spring-managed bean.
👉 When Spring scans the classpath and finds @Component, it creates an object (bean) of that class and manages its lifecycle.

🔍 Comparison Table (Very Important)

| Annotation        | Layer   | Purpose                        |
| ----------------- | ------- | ------------------------------ |
| `@Component`      | Generic | Common utility classes         |
| `@Service`        | Service | Business logic                 |
| `@Repository`     | DAO     | DB access + exception handling |
| `@Controller`     | MVC     | Web controllers                |
| `@RestController` | REST    | REST APIs                      |


@Component and @Service are functionally the same in Spring, but they are used for different semantic purposes to improve clarity and design.
 */



