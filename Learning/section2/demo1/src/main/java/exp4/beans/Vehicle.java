package exp4.beans;


import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Vehicle {
    private String name ;

    public String getName(){
        return name ;
    }

    public void setName(String name){
        this.name = name ;
    }

    public void about(){
        System.out.println("this is a about section") ;
    }

    @PostConstruct
    public void initialize(){
        System.out.println("this is postconstruct , will get call when Vehicle class created");
    }
}
